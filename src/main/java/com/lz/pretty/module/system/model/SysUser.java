package com.lz.pretty.module.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lz.pretty.common.domain.BaseColumns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息表
 */
@ApiModel(value = "用户信息表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
public class SysUser extends BaseColumns {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 组织id
     */
    @TableField(value = "org_id")
    @ApiModelProperty(value = "组织id")
    private Long orgId;

    /**
     * 0禁用用户，1是激活用户
     */
    @TableField(value = "enabled")
    @ApiModelProperty(value = "0禁用用户，1是激活用户")
    private Boolean enabled;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * email
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "email")
    private String email;
}
