package com.lz.pretty.module.security.rest;

import com.lz.pretty.common.domain.AjaxResponse;
import com.lz.pretty.common.exception.CustomException;
import com.lz.pretty.module.security.bean.JwtProperties;
import com.lz.pretty.module.security.service.JwtAuthService;
import com.lz.pretty.module.security.service.dto.AuthUserDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    JwtAuthService jwtAuthService;

    @PostMapping("/authentication")
    public AjaxResponse login(@RequestBody @Valid AuthUserDto userDto) {

        String username = userDto.getUsername();
        String password = userDto.getPassword();

        try {
            HashMap<String, Object> resultToken = new HashMap<>();
            resultToken.put("token",jwtAuthService.login(username, password));
            return AjaxResponse.success(resultToken);
        } catch (CustomException e) {
            return AjaxResponse.error(e);
        }
    }

    @RequestMapping("/refreshtoken")
    public AjaxResponse refresh(@RequestHeader("${pretty.jwt.header}") String token) {
        return AjaxResponse.success(jwtAuthService.refreshToken(token));
    }

    @RequestMapping("/roles")
    public AjaxResponse roles(@RequestHeader("${pretty.jwt.header}") String token) {
        return AjaxResponse.success(jwtAuthService.roles(token));
    }
}
