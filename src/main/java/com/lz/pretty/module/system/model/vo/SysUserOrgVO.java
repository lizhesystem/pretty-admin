package com.lz.pretty.module.system.model.vo;

import com.lz.pretty.module.system.model.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 类描述: SysUserVo
 *
 * @author Lz on 2022-06-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserOrgVO extends SysUser {
    private String orgName;

    private Date createStartTime;

    private Date createEndTime;
}
