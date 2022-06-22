package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lz.pretty.common.constant.CustomExceptionType;
import com.lz.pretty.common.exception.CustomException;
import com.lz.pretty.common.utils.tree.DataTreeUtil;
import com.lz.pretty.module.system.mapper.MySystemMapper;
import com.lz.pretty.module.system.mapper.SysMenuMapper;
import com.lz.pretty.module.system.mapper.SysRoleMenuMapper;
import com.lz.pretty.module.system.model.SysMenu;
import com.lz.pretty.module.system.model.SysRoleMenu;
import com.lz.pretty.module.system.model.treenode.SysMenuNode;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysMenuService {

    @Autowired
    private MySystemMapper mySystemMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 构造tree菜单
     *
     * @param menuNameLike 菜单名称模块查询
     * @param menuStatus   菜单状态
     * @return
     */
    public List<SysMenuNode> getMenuTree(String menuNameLike, Boolean menuStatus) {

        // 保证数据库里 level=1的根节点只有一个
        SysMenu rootSysMenu = sysMenuMapper.selectOne(new QueryWrapper<SysMenu>().eq("level", 1));
        if (rootSysMenu != null) {
            Long rootMenuId = rootSysMenu.getId();
            List<SysMenu> sysMenus = mySystemMapper.selectMenuTree(rootMenuId, menuNameLike, menuStatus);

            List<SysMenuNode> sysMenuNodes = sysMenus.stream().map(item -> {
                SysMenuNode node = new SysMenuNode();
                BeanUtils.copyProperties(item, node);
                return node;
            }).collect(Collectors.toList());

            if (StringUtils.isEmpty(menuNameLike)) {
                // 为空返回tree型菜单树
                return DataTreeUtil.buildTree(sysMenuNodes, rootMenuId);
            } else {
                // 不为空返回命名查询列表
                return sysMenuNodes;
            }

        } else {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                    "请先在数据库内为菜单配置一个分类的根节点，level=1");
        }
    }

    // 新增菜单
    public void addMenu(SysMenu sysMenu) {
        setMenuIdsAndLevel(sysMenu);

        sysMenu.setIsLeaf(true);
        SysMenu parent = new SysMenu();
        parent.setIsLeaf(false);
        parent.setId(sysMenu.getMenuPid());
        sysMenuMapper.updateById(parent);

        // 新增默认节点可用
        sysMenu.setStatus(false);
        sysMenuMapper.insert(sysMenu);
    }

    private void setMenuIdsAndLevel(SysMenu sysMenu) {
        List<SysMenu> sysMenus = sysMenuMapper.selectList(null);

        // 设置menu_pids以及level
        for (SysMenu menu : sysMenus) {
            if (menu.getId().equals(sysMenu.getMenuPid())) {
                sysMenu.setMenuPids(menu.getMenuPids() + ",[" + sysMenu.getMenuPid() + "]");
                sysMenu.setLevel(sysMenu.getLevel() + 1);
            }
        }
    }

    // 修改菜单
    public void update(SysMenu sysMenu) {
        Assert.isTrue(sysMenu.getId() != null, "修改操作必须带主键");
        sysMenuMapper.updateById(sysMenu);
    }

    // 删除菜单
    public void delete(SysMenu sysMenu) {
        List<SysMenu> myChilds = sysMenuMapper.selectList(new QueryWrapper<SysMenu>()
                .like("menu_pids", "[" + sysMenu.getId() + "]"));

        if (myChilds.size() > 0) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "" +
                    "下级菜单存在数据不允许删掉");
        }

        // 父类节点下是否有多个子节点，如果没有节点了设置父类为叶子节点
        List<SysMenu> myFatherChilds = sysMenuMapper.selectList(new QueryWrapper<SysMenu>()
                .like("menu_pids", "[" + sysMenu.getMenuPid() + "]"));


        if (myFatherChilds.size() == 1) {
            SysMenu parent = new SysMenu();
            parent.setId(sysMenu.getMenuPid());
            parent.setIsLeaf(true);
            sysMenuMapper.updateById(parent);
        }

        sysMenuMapper.deleteById(sysMenu.getId());

    }

    // 更改菜单状态
    public void updateStatus(Long menuId, Boolean status) {
        Assert.isTrue(menuId != null, "修改操作必须带主键");
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(menuId);
        sysMenu.setStatus(status);
        sysMenuMapper.updateById(sysMenu);

    }

    // 获取在角色设置菜单权限展开的项
    public List<String> getExpandedKeys() {
        return mySystemMapper.selectMenuExpandedKeys();
    }

    // 获取在角色设置菜单权限勾选的项
    public List<String> getCheckedKeys(Integer roleId) {
        return mySystemMapper.selectMenuCheckedKeys(roleId);
    }


    // 保存菜单权限,先删再插
    @Transactional
    public void saveCheckedKeys(Long roleId, List<Long> checkedIds) {
        sysRoleMenuMapper.delete(new QueryWrapper<SysRoleMenu>().eq("role_id", roleId));
        mySystemMapper.insertRoleMenuIds(roleId, checkedIds);
    }

    public List<SysMenuNode> getMenuTreeByUsername(String username) {
        List<SysMenu> sysMenus = mySystemMapper.selectMenuByUsername(username);

        if (sysMenus.size() > 0) {
            Long routMenuId = sysMenus.get(0).getId();

            List<SysMenuNode> sysMenuNodes = sysMenus.stream().map(item -> {
                SysMenuNode node = new SysMenuNode();
                BeanUtils.copyProperties(item, node);
                return node;
            }).collect(Collectors.toList());

            return DataTreeUtil.buildTreeWithoutRoot(sysMenuNodes, routMenuId);
        }
        return new ArrayList<>();
    }
}
