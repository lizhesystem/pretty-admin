package com.lz.pretty.common.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 数据库表通用字段
 */
@Getter
@Setter
@ToString
public class BaseColumns implements Serializable {

    /**
     * 本条记录创建人
     */
    @TableField(fill = FieldFill.INSERT, select = false)
    @ApiModelProperty(value = "创建人", hidden = true)
    private String createBy;

    /**
     * 本条记录创建时间
     */
    @TableField(fill = FieldFill.INSERT, select = true)
    @ApiModelProperty(value = "创建时间", hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 本条记录更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE, select = false)
    @ApiModelProperty(value = "更新人", hidden = true)
    private String updateBy;

    /**
     * 本条记录更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE, select = true)
    @ApiModelProperty(value = "更新时间", hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /**
     * 请求参数
     */
    @TableField(exist = false)
    private Map<String, Object> params;
}
