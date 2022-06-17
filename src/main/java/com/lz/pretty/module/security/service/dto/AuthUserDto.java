package com.lz.pretty.module.security.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * 类描述:
 *
 * @author lz
 * @create 2022-06-15 13:51
 */
@Getter
@Setter
@ToString
public class AuthUserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    // 验证码
    private String code;
}
