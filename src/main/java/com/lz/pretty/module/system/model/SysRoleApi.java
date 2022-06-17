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
    * 角色接口权限关系表
    */
@ApiModel(value="角色接口权限关系表")
@Getter
@Setter
@ToString
@Builder
@TableName(value = "sys_role_api")
public class SysRoleApi {
    /**
     * 角色id
     */
    @ApiModelProperty(value="角色id")
    private Long roleId;

    /**
     * 接口id
     */
    @ApiModelProperty(value="接口id")
    private Long apiId;
}