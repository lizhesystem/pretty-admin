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
 * 系统Http接口表，配合sys_role_api控制接口访问权限
 */
@ApiModel(value = "系统Http接口表，配合sys_role_api控制接口访问权限")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_api")
public class SysApi extends BaseColumns {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 接口父ID(即接口分组)
     */
    @TableField(value = "api_pid")
    @ApiModelProperty(value = "接口父ID(即接口分组)")
    private Long apiPid;

    /**
     * 当前接口的所有上级id(即所有上级分组)
     */
    @TableField(value = "api_pids")
    @ApiModelProperty(value = "当前接口的所有上级id(即所有上级分组)")
    private String apiPids;

    /**
     * 0:不是叶子节点，1:是叶子节点
     */
    @TableField(value = "is_leaf")
    @ApiModelProperty(value = "0:不是叶子节点，1:是叶子节点")
    private Boolean isLeaf;

    /**
     * 接口名称
     */
    @TableField(value = "api_name")
    @ApiModelProperty(value = "接口名称")
    private String apiName;

    /**
     * 跳转URL
     */
    @TableField(value = "url")
    @ApiModelProperty(value = "跳转URL")
    private String url;

    /**
     * 排序
     */
    @TableField(value = "api_sort")
    @ApiModelProperty(value = "排序")
    private Integer apiSort;

    /**
     * 层级，1：接口分组，2：接口
     */
    @TableField(value = "`level`")
    @ApiModelProperty(value = "层级，1：接口分组，2：接口")
    private Integer level;

    /**
     * 是否禁用，0:启用(否）,1:禁用(是)
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value = "是否禁用，0:启用(否）,1:禁用(是)")
    private Boolean status;

}
