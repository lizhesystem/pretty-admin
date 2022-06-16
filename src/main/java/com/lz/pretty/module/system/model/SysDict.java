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
    * 数据字典表
    */
@ApiModel(value="数据字典表")
@Getter
@Setter
@ToString
@Builder
@TableName(value = "sys_dict")
public class SysDict {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 分组名称
     */
    @TableField(value = "group_name")
    @ApiModelProperty(value="分组名称")
    private String groupName;

    /**
     * 分组编码
     */
    @TableField(value = "group_code")
    @ApiModelProperty(value="分组编码")
    private String groupCode;

    /**
     * 字典项名称
     */
    @TableField(value = "item_name")
    @ApiModelProperty(value="字典项名称")
    private String itemName;

    /**
     * 字典项Value
     */
    @TableField(value = "item_value")
    @ApiModelProperty(value="字典项Value")
    private String itemValue;

    /**
     * 字典项描述
     */
    @TableField(value = "item_desc")
    @ApiModelProperty(value="字典项描述")
    private String itemDesc;

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