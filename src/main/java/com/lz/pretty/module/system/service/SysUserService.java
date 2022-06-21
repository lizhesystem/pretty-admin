package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lz.pretty.module.system.mapper.SysUserMapper;
import com.lz.pretty.module.system.model.SysUser;
import com.lz.pretty.module.system.model.vo.SysUserOrgVO;
import io.jsonwebtoken.lang.Assert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserService {


    @Resource
    private SysUserMapper sysUserMapper;


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
}
