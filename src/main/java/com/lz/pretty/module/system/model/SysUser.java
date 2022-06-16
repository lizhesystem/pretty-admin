package com.lz.pretty.module.system.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
    * 用户信息表
    */
@ApiModel(value="用户信息表")
@Getter
@Setter
@ToString
@Builder
@TableName(value = "sys_user")
public class SysUser {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 组织id
     */
    @TableField(value = "org_id")
    @ApiModelProperty(value="组织id")
    private Long orgId;

    /**
     * 0禁用用户，1是激活用户
     */
    @TableField(value = "enabled")
    @ApiModelProperty(value="0禁用用户，1是激活用户")
    private Boolean enabled;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * email
     */
    @TableField(value = "email")
    @ApiModelProperty(value="email")
    private String email;

    /**
     * 本条记录创建人
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value="本条记录创建人")
    private String createBy;

    /**
     * 本条记录创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="本条记录创建时间")
    private Date createTime;

    /**
     * 本条记录修改人
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value="本条记录修改人")
    private String updateBy;

    /**
     * 本条记录的修改时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="本条记录的修改时间")
    private Date updateTime;
}