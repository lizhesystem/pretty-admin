package com.lz.pretty.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lz.pretty.module.system.model.SysOrg;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOrgMapper extends BaseMapper<SysOrg> {
    int updateBatch(List<SysOrg> list);

    int updateBatchSelective(List<SysOrg> list);

    int batchInsert(@Param("list") List<SysOrg> list);

    int insertOrUpdate(SysOrg record);

    int insertOrUpdateSelective(SysOrg record);
}