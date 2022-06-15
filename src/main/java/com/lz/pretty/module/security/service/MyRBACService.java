package com.lz.pretty.module.security.service;

import com.lz.pretty.module.security.bean.JwtProperties;
import com.lz.pretty.module.security.mapper.MyRBACServiceMapper;
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
public class MyRBACService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Resource
    private JwtProperties jwtProperties;


    @Resource
    private MyRBACServiceMapper myRBACServiceMapper;


    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = ((UserDetails) principal);

            List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(request.getRequestURI());

            // 判断某用户是否具有该request资源的访问权限
            return userDetails.getAuthorities().contains(authorityList.get(0))
                    || jwtProperties.getDevOpeningURI().contains(request.getRequestURI());
        }
        return false;
    }

}
