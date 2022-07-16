package com.lz.pretty.module.security.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 类描述:
 *
 * @author lz
 * @create 2022-06-15 13:51
 */
@Data
public class AuthUserDto {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    // 验证码
    private String code;
}
