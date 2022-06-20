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
 * 系统全局配置参数
 */
@ApiModel(value = "系统全局配置参数")
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_config")
public class SysConfig extends BaseColumns {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 参数名称(中文)
     */
    @TableField(value = "param_name")
    @ApiModelProperty(value = "参数名称(中文)")
    private String paramName;

    /**
     * 参数编码唯一标识(英文及数字)
     */
    @TableField(value = "param_key")
    @ApiModelProperty(value = "参数编码唯一标识(英文及数字)")
    private String paramKey;

    /**
     * 参数值
     */
    @TableField(value = "param_value")
    @ApiModelProperty(value = "参数值")
    private String paramValue;

    /**
     * 参数描述备注
     */
    @TableField(value = "param_desc")
    @ApiModelProperty(value = "参数描述备注")
    private String paramDesc;
}
