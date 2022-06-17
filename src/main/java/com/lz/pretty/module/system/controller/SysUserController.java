package com.lz.pretty.module.system.controller;

import com.lz.pretty.common.domain.AjaxResponse;
import com.lz.pretty.module.system.model.SysUser;
import com.lz.pretty.module.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.ClosedFileSystemException;

/**
 * 类描述:
 * 用户管理
 *
 * @author Administrator
 * @create 2022-06-16 22:25
 */
@RestController
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/info")
    public AjaxResponse info(@RequestParam("username") String username) {
        SysUser sysUser = sysUserService.getUserByUserName(username);
        System.out.println(sysUser.toString());
        return AjaxResponse.success(sysUser);
    }
}