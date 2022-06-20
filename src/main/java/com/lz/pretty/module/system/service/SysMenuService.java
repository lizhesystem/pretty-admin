package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lz.pretty.common.constant.CustomExceptionType;
import com.lz.pretty.common.exception.CustomException;
import com.lz.pretty.common.utils.tree.DataTreeUtil;
import com.lz.pretty.module.system.mapper.MySystemMapper;
import com.lz.pretty.module.system.mapper.SysMenuMapper;
import com.lz.pretty.module.system.model.SysMenu;
import com.lz.pretty.module.system.model.node.SysMenuNode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysMenuService {

    @Autowired
    private MySystemMapper mySystemMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;


    /**
     * 构造tree菜单
     * @param menuNameLike 菜单名称模块查询
     * @param menuStatus 菜单状态
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
}
