package com.lz.pretty.module.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 角色菜单权限关系表
 */
@ApiModel(value = "角色菜单权限关系表")
@Data
@TableName(value = "sys_role_menu")
public class SysRoleMenu {
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id")
    private Long menuId;
}
