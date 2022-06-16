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
    * 用户角色关系表
    */
@ApiModel(value="用户角色关系表")
@Getter
@Setter
@ToString
@Builder
@TableName(value = "sys_user_role")
public class SysUserRole {
    /**
     * 角色自增id
     */
    @TableId(value = "role_id", type = IdType.INPUT)
    @ApiModelProperty(value="角色自增id")
    private Long roleId;

    /**
     * 用户自增id
     */
    @TableId(value = "user_id", type = IdType.INPUT)
    @ApiModelProperty(value="用户自增id")
    private Long userId;
}