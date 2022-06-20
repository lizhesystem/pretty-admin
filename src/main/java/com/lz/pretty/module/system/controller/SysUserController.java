package com.lz.pretty.module.system.controller;

import com.lz.pretty.module.system.model.SysUser;
import com.lz.pretty.module.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述:
 * 用户管理
 *
 * @author Administrator
 * @create 2022-06-16 22:25
 */
@RestController
@RequestMapping("/sysuser")
@Api(tags = "用户管理", value = "用户管理")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名称", name = "username", paramType = "path")
    })

    @GetMapping("/info")
    public SysUser info(@RequestParam("username") String username) {
        return sysUserService.getUserByUserName(username);
    }
}
