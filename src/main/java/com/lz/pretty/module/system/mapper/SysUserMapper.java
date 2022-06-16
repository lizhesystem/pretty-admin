package com.lz.pretty.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lz.pretty.module.system.model.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper extends BaseMapper<SysUser> {
    int updateBatch(List<SysUser> list);

    int updateBatchSelective(List<SysUser> list);

    int batchInsert(@Param("list") List<SysUser> list);

    int insertOrUpdate(SysUser record);

    int insertOrUpdateSelective(SysUser record);
}