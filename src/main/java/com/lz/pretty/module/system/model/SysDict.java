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
 * 数据字典表
 */
@ApiModel(value = "数据字典表")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_dict")
public class SysDict extends BaseColumns {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 分组名称
     */
    @TableField(value = "group_name")
    @ApiModelProperty(value = "分组名称")
    private String groupName;

    /**
     * 分组编码
     */
    @TableField(value = "group_code")
    @ApiModelProperty(value = "分组编码")
    private String groupCode;

    /**
     * 字典项名称
     */
    @TableField(value = "item_name")
    @ApiModelProperty(value = "字典项名称")
    private String itemName;

    /**
     * 字典项Value
     */
    @TableField(value = "item_value")
    @ApiModelProperty(value = "字典项Value")
    private String itemValue;

    /**
     * 字典项描述
     */
    @TableField(value = "item_desc")
    @ApiModelProperty(value = "字典项描述")
    private String itemDesc;
}
