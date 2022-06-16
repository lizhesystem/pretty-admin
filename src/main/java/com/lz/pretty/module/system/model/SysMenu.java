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
    * 系统菜单表
    */
@ApiModel(value="系统菜单表")
@Getter
@Setter
@ToString
@Builder
@TableName(value = "sys_menu")
public class SysMenu {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 父菜单ID
     */
    @TableField(value = "menu_pid")
    @ApiModelProperty(value="父菜单ID")
    private Long menuPid;

    /**
     * 当前菜单所有父菜单
     */
    @TableField(value = "menu_pids")
    @ApiModelProperty(value="当前菜单所有父菜单")
    private String menuPids;

    /**
     * 菜单名称
     */
    @TableField(value = "menu_name")
    @ApiModelProperty(value="菜单名称")
    private String menuName;

    /**
     * 排序
     */
    @TableField(value = "menu_sort")
    @ApiModelProperty(value="排序")
    private Integer menuSort;

    /**
     * 0:不是叶子节点，1:是叶子节点
     */
    @TableField(value = "is_leaf")
    @ApiModelProperty(value="0:不是叶子节点，1:是叶子节点")
    private Boolean isLeaf;

    /**
     * 跳转URL
     */
    @TableField(value = "url")
    @ApiModelProperty(value="跳转URL")
    private String url;

    @TableField(value = "icon")
    @ApiModelProperty(value="")
    private String icon;

    /**
     * 菜单层级
     */
    @TableField(value = "`level`")
    @ApiModelProperty(value="菜单层级")
    private Integer level;

    /**
     * 是否禁用，0:启用(否）,1:禁用(是)
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="是否禁用，0:启用(否）,1:禁用(是)")
    private Boolean status;

    /**
     * 是否隐藏，0:不隐藏，1:隐藏，某些页面入口不在菜单上显示
     */
    @TableField(value = "hidden")
    @ApiModelProperty(value="是否隐藏，0:不隐藏，1:隐藏，某些页面入口不在菜单上显示")
    private Boolean hidden;

    /**
     * 前端路由组件页面文件import路径
     */
    @TableField(value = "view_import")
    @ApiModelProperty(value="前端路由组件页面文件import路径")
    private String viewImport;

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