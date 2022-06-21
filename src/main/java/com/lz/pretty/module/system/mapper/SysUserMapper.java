package com.lz.pretty.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lz.pretty.module.system.model.SysUser;
import com.lz.pretty.module.system.model.vo.SysUserOrgVO;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUserOrgVO> queryList(SysUserOrgVO sysUser);
}
