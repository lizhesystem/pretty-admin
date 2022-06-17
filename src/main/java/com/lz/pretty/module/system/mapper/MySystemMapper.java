package com.lz.pretty.module.system.mapper;

import com.lz.pretty.module.system.model.SysOrg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口描述: 系统公共mapper
 *
 * @author Lz on 2022-06-17
 */
public interface MySystemMapper {

    List<SysOrg> selectOrgTree(@Param("rootOrgId") Long rootOrgId,
                               @Param("orgNameLike") String orgNameLike,
                               @Param("orgStatus") Boolean orgStatus);
}
