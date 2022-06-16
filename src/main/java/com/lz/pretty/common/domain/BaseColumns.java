package com.lz.pretty.common.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

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
  @TableField(fill = FieldFill.INSERT, select = false)
  @ApiModelProperty(value = "创建时间", hidden = true)
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
  @TableField(fill = FieldFill.INSERT_UPDATE, select = false)
  @ApiModelProperty(value = "更新时间", hidden = true)
  private LocalDateTime updateTime;

}
