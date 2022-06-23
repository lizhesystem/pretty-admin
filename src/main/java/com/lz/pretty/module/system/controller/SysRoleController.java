package com.lz.pretty.module.system.controller;

import com.lz.pretty.common.domain.AjaxResponse;
import com.lz.pretty.module.system.model.SysRole;
import com.lz.pretty.module.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 类描述: 角色管理
 *
 * @author Lz on 2022-06-21
 */
@RestController
@RequestMapping("/sysrole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping(value = "/query")
    public AjaxResponse query(@RequestParam("roleLike") String roleLike) {
        return AjaxResponse.success(sysRoleService.queryRoles(roleLike));
    }

    @PostMapping(value = "/update")
    public AjaxResponse update(@RequestBody SysRole sysRole) {
        sysRoleService.updateRole(sysRole);
        return AjaxResponse.success("更新角色成功！");
    }

    @PostMapping(value = "/add")
    public AjaxResponse add(@RequestBody SysRole sysRole) {
        sysRoleService.addRole(sysRole);
        return AjaxResponse.success("新增角色成功！");
    }

    @PostMapping(value = "/delete")
    public AjaxResponse delete(@RequestParam Integer roleId) {
        sysRoleService.deleteRole(roleId);
        return AjaxResponse.success("删除角色成功!");
    }

    //角色管理：更新角色禁用状态
    @PostMapping(value = "/status/change")
    public AjaxResponse update(@RequestParam Long roleId,
                               @RequestParam Boolean status) {
        sysRoleService.updateStatus(roleId, status);
        return AjaxResponse.success("角色禁用状态更新成功！");
    }
}
