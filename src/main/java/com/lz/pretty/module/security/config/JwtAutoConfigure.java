package com.lz.pretty.module.security.config;

import com.lz.pretty.common.utils.JwtTokenUtil;
import com.lz.pretty.module.security.bean.JwtProperties;
import com.lz.pretty.module.security.service.MyUserDetailsService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 类描述:jwt自动装配类，装配JwtTokenUtil 和 JwtAuthenticationTokenFilter
 *
 * @author lz
 * @create 2022-06-15 16:16
 */
@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class JwtAutoConfigure {


    @Resource
    private JwtProperties jwtProperties;


    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil(jwtProperties);
    }

    /**
     * @param jwtTokenUtil         jwt工具Bean
     * @param myUserDetailsService 用户详情
     * @return
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(
            JwtTokenUtil jwtTokenUtil,
            MyUserDetailsService myUserDetailsService) {

        return new JwtAuthenticationTokenFilter(
                this.jwtProperties,
                jwtTokenUtil,
                myUserDetailsService);
    }


}
