package com.lz.pretty.module.system.mapper;

import com.lz.pretty.module.system.model.SysApi;
import com.lz.pretty.module.system.model.SysMenu;
import com.lz.pretty.module.system.model.SysOrg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口描述: 系统公共mapper
 *
 * @author Lz on 2022-06-17
 */
public interface MySystemMapper {

    /**
     * 获取组织机构
     *
     * @param rootOrgId
     * @param orgNameLike
     * @param orgStatus
     * @return
     */
    List<SysOrg> selectOrgTree(@Param("rootOrgId") Long rootOrgId,
                               @Param("orgNameLike") String orgNameLike,
                               @Param("orgStatus") Boolean orgStatus);


    /**
     * 获取菜单
     *
     * @param rootMenuId
     * @param menuNameLike
     * @param menuStatus
     * @return
     */
    List<SysMenu> selectMenuTree(@Param("rootMenuId") Long rootMenuId,
                                 @Param("menuNameLike") String menuNameLike,
                                 @Param("menuStatus") Boolean menuStatus);


    /**
     * 获取接口
     * @param rootApiId
     * @param apiNameLike
     * @param apiStatus
     * @return
     */
    List<SysApi> selectApiTree(@Param("rootApiId") Integer rootApiId ,
                               @Param("apiNameLike") String apiNameLike,
                               @Param("apiStatus") Boolean apiStatus);
}
