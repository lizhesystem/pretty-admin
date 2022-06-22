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
     *
     * @param rootApiId
     * @param apiNameLike
     * @param apiStatus
     * @return
     */
    List<SysApi> selectApiTree(@Param("rootApiId") Long rootApiId,
                               @Param("apiNameLike") String apiNameLike,
                               @Param("apiStatus") Boolean apiStatus);

    /**
     * 获取某角色勾选的API访问权限的展开节点
     */
    List<String> selectApiExpandedKeys();


    /**
     * 获取在API分类树中展开的勾选的项
     *
     * @param roleId
     * @return
     */
    List<String> selectApiCheckedKeys(Integer roleId);

    /**
     * 批量保存角色勾选API接口权限
     *
     * @param roleId
     * @param checkedIds
     */
    void insertRoleApiIds(@Param("roleId") Long roleId, @Param("checkedIds") List<Long> checkedIds);


    /**
     * 获取某角色勾选的菜单的展开节点
     */
    List<String> selectMenuExpandedKeys();

    /**
     * 获取角色设置菜单树勾选的项
     *
     * @param roleId
     * @return
     */
    List<String> selectMenuCheckedKeys(Integer roleId);

    /**
     * 批量保存角色勾选API接口权限
     *
     * @param roleId
     * @param checkedIds
     */
    void insertRoleMenuIds(@Param("roleId") Long roleId, @Param("checkedIds") List<Long> checkedIds);


    /**
     * 根据用户名获取左侧菜单列表
     *
     * @param username
     * @return
     */
    List<SysMenu> selectMenuByUsername(String username);
}
