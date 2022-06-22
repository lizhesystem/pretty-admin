package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lz.pretty.common.constant.CustomExceptionType;
import com.lz.pretty.common.exception.CustomException;
import com.lz.pretty.config.DbLoadSysConfig;
import com.lz.pretty.module.system.mapper.SysUserMapper;
import com.lz.pretty.module.system.model.SysUser;
import com.lz.pretty.module.system.model.vo.SysUserOrgVO;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SysUserService {


    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DbLoadSysConfig dbLoadSysConfig;


    public SysUser getUserByUserName(String username) {
        Assert.isTrue(StringUtils.isNoneEmpty(username), "查询参数用户名不存在");
        SysUser sysUser = sysUserMapper.selectOne(
                new QueryWrapper<SysUser>().eq("username", username));
        if (sysUser != null) {
            sysUser.setPassword("");
        }
        return sysUser;
    }


    public List<SysUserOrgVO> queryUser(SysUserOrgVO sysUser) {
        return sysUserMapper.queryList(sysUser);
    }

    public void addUser(SysUser sysUser) {
        sysUser.setPassword(passwordEncoder.encode(
                dbLoadSysConfig.getConfigItem("user.init.password")
        ));
        sysUserMapper.insert(sysUser);
    }

    public void updateUser(SysUser sysUser) {
        Assert.isTrue(sysUser.getUsername() != null, "修改操作必须带用户名");
        // 根据用户名修改用户信息
        LambdaQueryWrapper<SysUser> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.eq(SysUser::getUsername, sysUser.getUsername());
        sysUserMapper.update(sysUser, lambdaQuery);
    }

    public void deleteUser(String username) {
        Assert.isTrue(StringUtils.isNotEmpty(username), "删除操作必须带主键");

        //根据用户名删除用户信息
        LambdaQueryWrapper<SysUser> lambdaQ = Wrappers.lambdaQuery();
        lambdaQ.eq(SysUser::getUsername, username);
        sysUserMapper.delete(lambdaQ);
    }

    public void pwsreset(Long userId) {
        if (userId == null) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "重置密码必须带主键");
        } else {
            SysUser sysUser = new SysUser();
            sysUser.setId(userId);
            String rawPassword = dbLoadSysConfig.getConfigItem("user.init.password");

            sysUser.setPassword(passwordEncoder.encode(rawPassword));
            sysUserMapper.updateById(sysUser);
        }

    }

    public boolean isdefault(String username) {
        SysUser sysUser = sysUserMapper.selectOne(new QueryWrapper<SysUser>()
                .eq("username", username));

        // 从系统参数里获取默认值
        String rawPassword = dbLoadSysConfig.getConfigItem("user.init.password");
        log.warn("获取到的初始密码为{}", rawPassword);
        return passwordEncoder.matches(rawPassword, sysUser.getPassword());
    }


    public void changePwd(String username, String oldPass, String newPass) {
        SysUser sysUser = sysUserMapper.selectOne(new QueryWrapper<SysUser>()
                .eq("username", username));

        //判断旧密码是否正确
        boolean isMatch = passwordEncoder.matches(oldPass, sysUser.getPassword());
        if (isMatch) {
            SysUser user = new SysUser();
            user.setId(sysUser.getId());
            user.setPassword(passwordEncoder.encode(newPass));
            sysUserMapper.updateById(user);
        } else {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR,
                    "原密码输入错误，请确认后重新输入！");
        }
    }
}
