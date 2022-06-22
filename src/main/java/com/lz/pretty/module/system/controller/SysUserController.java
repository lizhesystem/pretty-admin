package com.lz.pretty.module.system.controller;

import com.lz.pretty.common.controller.BaseController;
import com.lz.pretty.common.domain.AjaxResponse;
import com.lz.pretty.common.page.TableDataInfo;
import com.lz.pretty.module.system.model.SysUser;
import com.lz.pretty.module.system.model.vo.SysUserOrgVO;
import com.lz.pretty.module.system.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/info")
    public AjaxResponse info(@RequestParam("username") String username) {
        return AjaxResponse.success(sysUserService.getUserByUserName(username));
    }

    @PostMapping("/query")
    public TableDataInfo query(SysUserOrgVO sysUser) {
        startPage();
        List<SysUserOrgVO> sysUserList = sysUserService.queryUser(sysUser);
        return getDataTable(sysUserList);
    }

    //用户管理：新增
    @PostMapping("/add")
    public AjaxResponse add(@RequestBody SysUser sysUser) {
        sysUserService.addUser(sysUser);
        return AjaxResponse.success("新增用户成功！");
    }

    //用户管理：修改
    @PostMapping("/update")
    public AjaxResponse update(@RequestBody SysUser sysUser) {
        sysUserService.updateUser(sysUser);
        return AjaxResponse.success("更新用户成功！");
    }

    //用户管理：删除
    @PostMapping("/delete")
    public AjaxResponse delete(@RequestParam String username) {
        sysUserService.deleteUser(username);
        return AjaxResponse.success("删除用户成功！");
    }

    //用户管理：重置密码
    @PostMapping("/pwd/reset")
    public AjaxResponse pwdReset(@RequestParam Long userId) {
        sysUserService.pwsreset(userId);
        return AjaxResponse.success("重置密码成功！");
    }

    //用户管理：判断是否是初始化密码
    @PostMapping("/pwd/isdefulat")
    public AjaxResponse isDefault(@RequestParam String username) {
        return AjaxResponse.success(sysUserService.isdefault(username));
    }

    //用户管理：更改密码
    @PostMapping("/pwd/change")
    public AjaxResponse pwdChange(@RequestParam String username,
                                  @RequestParam String oldPass,
                                  @RequestParam String newPass) {
        sysUserService.changePwd(username, oldPass, newPass);
        return AjaxResponse.success("修改密码成功!");
    }
}
