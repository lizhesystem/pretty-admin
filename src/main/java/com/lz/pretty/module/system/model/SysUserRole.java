package com.lz.pretty.module.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户角色关系表
 */
@ApiModel(value = "用户角色关系表")
@Data
@TableName(value = "sys_user_role")
public class SysUserRole {
    /**
     * 角色自增id
     */
    @ApiModelProperty(value = "角色自增id")
    private Long roleId;

    /**
     * 用户自增id
     */
    @ApiModelProperty(value = "用户自增id")
    private Long userId;
}
