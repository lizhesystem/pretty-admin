package com.lz.pretty.module.system.controller;

import com.lz.pretty.common.domain.AjaxResponse;
import com.lz.pretty.module.system.model.SysMenu;
import com.lz.pretty.module.system.model.dto.RoleCheckedIdsDTO;
import com.lz.pretty.module.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * 类描述: 菜单管理
 *
 * @author Lz on 2022-06-20
 */
@RestController
@RequestMapping("/sysmenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("/tree")
    public AjaxResponse tree(@RequestParam("menuNameLike") String menuNameLike,
                             @RequestParam("menuStatus") Boolean menuStatus) {
        return AjaxResponse.success(sysMenuService.getMenuTree(menuNameLike, menuStatus));
    }

    @PostMapping("/add")
    public AjaxResponse add(@RequestBody SysMenu sysMenu) {
        sysMenuService.addMenu(sysMenu);
        return AjaxResponse.success("新增菜单成功！");
    }

    @PostMapping("/update")
    public AjaxResponse update(@RequestBody SysMenu sysMenu) {
        sysMenuService.update(sysMenu);
        return AjaxResponse.success("更新菜单成功！");
    }

    @PostMapping("/delete")
    public AjaxResponse delete(@RequestBody SysMenu sysMenu) {
        sysMenuService.delete(sysMenu);
        return AjaxResponse.success("删除菜单成功！");
    }

    //组织管理：更新组织禁用状态
    @PostMapping(value = "/status/change")
    public AjaxResponse update(@RequestParam Long menuId,
                               @RequestParam Boolean status) {
        sysMenuService.updateStatus(menuId, status);
        return AjaxResponse.success("菜单禁用状态更新成功！");
    }

    /**
     * 查询 菜单 树形结构：全部、已选、展开
     *
     * @return
     */
    @PostMapping(value = "/checkedtree")
    public AjaxResponse checkedTree(@RequestParam Integer roleId) {
        HashMap<String, Object> menuMaps = new HashMap<>();
        menuMaps.put("tree", sysMenuService.getMenuTree("", null));
        menuMaps.put("expendedKeys", sysMenuService.getExpandedKeys());
        menuMaps.put("checkedKeys", sysMenuService.getCheckedKeys(roleId));
        return AjaxResponse.success(menuMaps);
    }

    /**
     * 保存角色 菜单 权限
     *
     * @param roleCheckedIds
     * @return
     */
    @PostMapping(value = "/saveKeys")
    public AjaxResponse saveKeys(@RequestBody @Valid RoleCheckedIdsDTO roleCheckedIds) {
        sysMenuService.saveCheckedKeys(
                roleCheckedIds.getRoleId(),
                roleCheckedIds.getCheckedIds()
        );
        return AjaxResponse.success("保存接口权限成功！");
    }

    /**
     * 系统左侧菜单栏加载，根据用户名获取菜单
     *
     * @param username
     * @return
     */
    @PostMapping("/tree/user")
    public AjaxResponse userTree(@RequestParam String username) {
        return AjaxResponse.success(sysMenuService.getMenuTreeByUsername(username));
    }

}
