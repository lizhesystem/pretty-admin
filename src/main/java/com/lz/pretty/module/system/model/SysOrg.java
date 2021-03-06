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
 * 系统组织结构表
 */
@ApiModel(value = "系统组织结构表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_org")
public class SysOrg extends BaseColumns {

    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 上级组织编码
     */
    @TableField(value = "org_pid")
    @ApiModelProperty(value = "上级组织编码")
    private Long orgPid;

    /**
     * 所有的父节点id
     */
    @TableField(value = "org_pids")
    @ApiModelProperty(value = "所有的父节点id")
    private String orgPids;

    /**
     * 组织名
     */
    @TableField(value = "org_name")
    @ApiModelProperty(value = "组织名")
    private String orgName;

    /**
     * 排序
     */
    @TableField(value = "org_sort")
    @ApiModelProperty(value = "排序")
    private Integer orgSort;

    /**
     * 0:不是叶子节点，1:是叶子节点
     */
    @TableField(value = "is_leaf")
    @ApiModelProperty(value = "0:不是叶子节点，1:是叶子节点")
    private Boolean isLeaf;

    /**
     * 地址
     */
    @TableField(value = "address")
    @ApiModelProperty(value = "地址")
    private String address;

    /**
     * 电话
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "电话")
    private String phone;

    /**
     * 邮件
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "邮件")
    private String email;

    /**
     * 组织层级
     */
    @TableField(value = "`level`")
    @ApiModelProperty(value = "组织层级")
    private Integer level;

    /**
     * 是否禁用，0:启用(否）,1:禁用(是)
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value = "是否禁用，0:启用(否）,1:禁用(是)")
    private Boolean status;
}
