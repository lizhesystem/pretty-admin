package com.lz.pretty.module.system.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 类描述:角色分配API勾选DTO
 *
 * @author Lz on 2022-06-21
 */
@Data
public class RoleCheckedIdsDTO {

    private String roleCode;

    @NotBlank(message = "角色ID不能为空")
    private Long roleId;

    // 勾选的权限
    private List<Long> checkedIds;
}
