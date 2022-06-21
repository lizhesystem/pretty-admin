package com.lz.pretty.module.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lz.pretty.module.system.mapper.SysRoleMapper;
import com.lz.pretty.module.system.model.SysRole;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * @param roleLik 角色编码 或角色描述 或角色名称模糊查询
     * @return 角色记录列表
     */
    public List<SysRole> queryRoles(String roleLik) {

        QueryWrapper<SysRole> query = new QueryWrapper<>();
        // 入参匹配三个字段模糊查找,任何一个字段匹配成功都将当做查询结果返回。
        query.like(StringUtils.isNotEmpty(roleLik), "role_code", roleLik)
                .or()
                .like(StringUtils.isNotEmpty(roleLik), "role_desc", roleLik)
                .or()
                .like(StringUtils.isNotEmpty(roleLik), "role_name", roleLik);
        query.orderByAsc("role_sort");
        return sysRoleMapper.selectList(query);
    }

    // 角色管理：更新角色信息
    public void updateRole(SysRole sysRole) {
        Assert.isTrue(sysRole.getId() != null, "更新数据必须指定更新条件（主键）");
        sysRoleMapper.updateById(sysRole);
    }

    // 角色管理：新增角色
    public void addRole(SysRole sysRole) {
        //是否禁用:false
        sysRole.setStatus(false);
        sysRoleMapper.insert(sysRole);
    }

    // 角色管理：删除角色信息
    public void deleteRole(Integer id) {
        Assert.isTrue(id != null, "删除数据必须指定更新条件（主键）");
        sysRoleMapper.deleteById(id);
    }
}
