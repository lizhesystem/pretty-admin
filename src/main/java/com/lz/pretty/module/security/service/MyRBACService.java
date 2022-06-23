package com.lz.pretty.module.security.service;

import com.lz.pretty.module.security.bean.JwtProperties;
import com.lz.pretty.module.security.mapper.MyRBACServiceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类描述: 权限判断类
 *
 * @author lz
 * @create 2022-06-15 17:15
 */
@Component("rabcService")
@Slf4j
public class MyRBACService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Resource
    private JwtProperties jwtProperties;


    @Resource
    private MyRBACServiceMapper myRBACServiceMapper;


    /**
     * 接口鉴权拦截，判断用户是否有该资源的访问权限
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = ((UserDetails) principal);

            List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(request.getRequestURI());

            // 判断某用户是否具有该request资源的访问权限
            log.info("openURI = {}", jwtProperties.getDevOpeningURI().toString());
            return userDetails.getAuthorities().contains(authorityList.get(0))
                    || jwtProperties.getDevOpeningURI().contains(request.getRequestURI());
        }
        return false;
    }

}
