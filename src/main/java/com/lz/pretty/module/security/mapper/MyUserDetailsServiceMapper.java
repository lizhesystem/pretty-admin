package com.lz.pretty.module.security.mapper;

import com.lz.pretty.module.security.bean.MyUserDetails;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 类描述:
 *
 * @author lz
 * @create 2022-06-15 14:45
 */
public interface MyUserDetailsServiceMapper {

    //根据userID查询用户信息
    @Select("SELECT username,password,enabled\n" +
            "FROM sys_user u\n" +
            "WHERE u.username = #{userId} or u.phone = #{userId}")
    MyUserDetails findByUserName(@Param("userId") String userId);



    //根据userID查询用户角色列表
    @Select("SELECT role_code\n" +
            "FROM sys_role r\n" +
            "LEFT JOIN sys_user_role ur ON r.id = ur.role_id\n" +
            "LEFT JOIN sys_user u ON u.id = ur.user_id\n" +
            "WHERE u.username = #{userId} or u.phone = #{userId}")
    List<String> findRoleByUserName(@Param("userId") String userId);

    // 根据用户角色查询用户菜单权限
    @Select({
            "<script>",
            "SELECT url " ,
            "FROM sys_menu m " ,
            "LEFT JOIN sys_role_menu rm ON m.id = rm.menu_id " ,
            "LEFT JOIN sys_role r ON r.id = rm.role_id ",
            "WHERE r.role_code IN ",
            "<foreach collection='roleCodes' item='roleCode' open='(' separator=',' close=')'>",
            "#{roleCode}",
            "</foreach>",
            "</script>"
    })
    List<String> findAuthorityByRoleCodes(@Param("roleCodes") List<String> roleCodes);


    // 通过用户角色列表加载用户的资源权限列表
    @Select({
            "<script>",
            "SELECT url " ,
            "FROM sys_api a " ,
            "LEFT JOIN sys_role_api ra ON a.id = ra.api_id " ,
            "LEFT JOIN sys_role r ON r.id = ra.role_id ",
            "WHERE r.role_code IN ",
            "<foreach collection='roleCodes' item='roleCode' open='(' separator=',' close=')'>",
            "#{roleCode}",
            "</foreach>",
            "</script>"
    })
    List<String> findApiByRoleCodes(@Param("roleCodes") List<String> roleCodes);
}
