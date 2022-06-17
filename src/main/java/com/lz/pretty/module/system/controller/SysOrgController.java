package com.lz.pretty.module.system.controller;

import com.lz.pretty.module.system.model.SysOrgNode;
import com.lz.pretty.module.system.model.SysUser;
import com.lz.pretty.module.system.service.SysOrgService;
import com.lz.pretty.module.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
