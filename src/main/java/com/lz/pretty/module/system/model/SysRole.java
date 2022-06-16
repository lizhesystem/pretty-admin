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
    * 系统角色表
    */
@ApiModel(value="系统角色表")
@Getter
@Setter
@ToString
@Builder
@TableName(value = "sys_role")
public class SysRole {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 角色名称(汉字)
     */
    @TableField(value = "role_name")
    @ApiModelProperty(value="角色名称(汉字)")
    private String roleName;

    /**
     * 角色描述
     */
    @TableField(value = "role_desc")
    @ApiModelProperty(value="角色描述")
    private String roleDesc;

    /**
     * 角色的英文code.如：ADMIN
     */
    @TableField(value = "role_code")
    @ApiModelProperty(value="角色的英文code.如：ADMIN")
    private String roleCode;

    /**
     * 角色顺序
     */
    @TableField(value = "role_sort")
    @ApiModelProperty(value="角色顺序")
    private Integer roleSort;

    /**
     * 是否禁用，0:启用(否）,1:禁用(是)
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="是否禁用，0:启用(否）,1:禁用(是)")
    private Boolean status;

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