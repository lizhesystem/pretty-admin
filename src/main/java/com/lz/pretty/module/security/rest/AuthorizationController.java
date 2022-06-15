package com.lz.pretty.module.security.rest;

import com.lz.pretty.common.domain.AjaxResponse;
import com.lz.pretty.common.exception.CustomException;
import com.lz.pretty.module.security.bean.JwtProperties;
import com.lz.pretty.module.security.service.JwtAuthService;
import com.lz.pretty.module.security.service.dto.AuthUserDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 类描述:
 * 授权、根据token获取用户详细信息
 *
 * @author lz
 * @create 2022-06-13 11:49
 */
@RestController
public class AuthorizationController {

    @Resource
    JwtProperties jwtProperties;

    @Resource
    JwtAuthService jwtAuthService;

    @PostMapping("/authentication")
    public AjaxResponse login(@Validated @RequestBody AuthUserDto userDto) {

        String username = userDto.getUsername();
        String password = userDto.getPassword();

        try {
            return AjaxResponse.success(jwtAuthService.login(username, password));
        } catch (CustomException e) {
            return AjaxResponse.error(e);
        }
    }

    @RequestMapping("/refreshtoken")
    public AjaxResponse refresh(@RequestHeader("${pretty.jwt.header}") String token) {
        return AjaxResponse.success(jwtAuthService.refreshToken(token));
    }
}
