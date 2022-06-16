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
    * 系统全局配置参数
    */
@ApiModel(value="系统全局配置参数")
@Getter
@Setter
@ToString
@Builder
@TableName(value = "sys_config")
public class SysConfig {
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="")
    private Long id;

    /**
     * 参数名称(中文)
     */
    @TableField(value = "param_name")
    @ApiModelProperty(value="参数名称(中文)")
    private String paramName;

    /**
     * 参数编码唯一标识(英文及数字)
     */
    @TableField(value = "param_key")
    @ApiModelProperty(value="参数编码唯一标识(英文及数字)")
    private String paramKey;

    /**
     * 参数值
     */
    @TableField(value = "param_value")
    @ApiModelProperty(value="参数值")
    private String paramValue;

    /**
     * 参数描述备注
     */
    @TableField(value = "param_desc")
    @ApiModelProperty(value="参数描述备注")
    private String paramDesc;

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