package com.lz.pretty.module.system.controller;

import com.lz.pretty.common.domain.AjaxResponse;
import com.lz.pretty.module.system.model.SysOrg;
import com.lz.pretty.module.system.model.SysUser;
import com.lz.pretty.module.system.model.node.SysOrgNode;
import com.lz.pretty.module.system.service.SysOrgService;
import com.lz.pretty.module.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述: 组织机构
 *
 * @author Lz on 2022-06-17
 */
@RestController
@RequestMapping("/sysorg")
public class SysOrgController {

    @Autowired
    private SysOrgService sysOrgService;

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/tree")
    public List<SysOrgNode> tree(@RequestParam("username") String username,
                                 @RequestParam("orgNameLike") String orgNameLike,
                                 @RequestParam("orgStatus") Boolean orgStatus) {
        SysUser sysUser = sysUserService.getUserByUserName(username);
        return sysOrgService.getOrgTreeById(sysUser.getOrgId(), orgNameLike, orgStatus);
    }

    @PostMapping("/add")
    public AjaxResponse add(@RequestBody SysOrg sysOrg) {
        sysOrgService.addOrg(sysOrg);
        return AjaxResponse.success("新增组织机构成功！");
    }

    @PostMapping("/update")
    public AjaxResponse update(@RequestBody SysOrg sysOrg) {
        sysOrgService.update(sysOrg);
        return AjaxResponse.success("更新组织机构成功！");
    }

    @PostMapping("/delete")
    public AjaxResponse delete(@RequestBody SysOrg sysOrg) {
        sysOrgService.delete(sysOrg);
        return AjaxResponse.success("删除组织机构成功！");
    }

    //组织管理：更新组织禁用状态
    @PostMapping(value = "/status/change")
    public AjaxResponse update(@RequestParam Long orgId,
                               @RequestParam Boolean status) {
        sysOrgService.updateStatus(orgId, status);
        return AjaxResponse.success("组织禁用状态更新成功！");
    }
}
