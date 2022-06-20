package com.lz.pretty.module.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 角色接口权限关系表
 */
@ApiModel(value = "角色接口权限关系表")
@Data
@TableName(value = "sys_role_api")
public class SysRoleApi {
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long roleId;

    /**
     * 接口id
     */
    @ApiModelProperty(value = "接口id")
    private Long apiId;
}
