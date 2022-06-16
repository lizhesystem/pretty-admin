package com.lz.pretty.module.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
    * 角色菜单权限关系表
    */
@ApiModel(value="角色菜单权限关系表")
@Getter
@Setter
@ToString
@Builder
@TableName(value = "sys_role_menu")
public class SysRoleMenu {
    /**
     * 角色id
     */
    @TableId(value = "role_id", type = IdType.INPUT)
    @ApiModelProperty(value="角色id")
    private Long roleId;

    /**
     * 权限id
     */
    @TableId(value = "menu_id", type = IdType.INPUT)
    @ApiModelProperty(value="权限id")
    private Long menuId;
}