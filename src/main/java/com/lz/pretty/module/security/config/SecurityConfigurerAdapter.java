package com.lz.pretty.module.security.config;

import com.lz.pretty.common.utils.JwtTokenUtil;
import com.lz.pretty.module.security.bean.JwtProperties;
import com.lz.pretty.module.security.service.JwtAuthService;
import com.lz.pretty.module.security.service.MyUserDetailsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;

/**
 * /**
 * Spring Security 配置
 * 可以配置多个WebSecurityConfigurerAdapter
 * 但是多个Adaptor有执行顺序，默认值是100
 * 这里设置为1会优先执行
 *
 * @author lz
 * @create 2022-06-15 15:36
 */
@Configuration
@Order(1)
public class SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Resource
    private JwtProperties jwtProperties;

    @Resource
    private MyUserDetailsService myUserDetailsService;

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (jwtProperties.getCsrfDisabled()) {
            http = http.csrf().disable();
        }
        http.cors()
                .and().addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/authentication", "/refreshtoken").permitAll();
        // 通过配置实现的不需要JWT令牌就可以访问的接口
        for (String uri : jwtProperties.getPermitAllURI()) {
            http.authorizeRequests().antMatchers(uri).permitAll();
        }
        // RBAC权限控制级别的接口权限校验
        http.authorizeRequests().anyRequest()
                .access("@rabcService.hasPermission(request,authentication)");
    }

    // 认证基于BCryptPasswordEncoder加密解密
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 跨站资源共享配置
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(jwtProperties.getCorsAllowedOrigins());
        configuration.setAllowedMethods(jwtProperties.getCorsAllowedMethods());
        configuration.applyPermitDefaultValues();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    // 因为使用到了AuthenticationManager
    // 将AuthenticationManager 声明为一个Bean
    @Override
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @ConditionalOnMissingBean(AuthenticationManager.class)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // 初始化JwtAuthService Bean
    @Bean
    public JwtAuthService jwtAuthService(
            MyUserDetailsService myUserDetailsService,
            JwtTokenUtil jwtTokenUtil) throws Exception {

        return new JwtAuthService(
                this.authenticationManagerBean(),
                myUserDetailsService,
                jwtTokenUtil);
    }

    //public static void main(String[] args) {
    //    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //    String rawPassword = "123456";  //原始密码
    //    String encodedPassword = passwordEncoder.encode(rawPassword); //加密后的密码
    //    System.out.println("原始密码" + rawPassword);
    //    System.out.println("加密之后的hash密码:" + encodedPassword);
    //
    //
    //    System.out.println(rawPassword + "是否匹配" + encodedPassword + ":"   //密码校验：true
    //            + passwordEncoder.matches(rawPassword, encodedPassword));
    //
    //    System.out.println("654321是否匹配" + encodedPassword + ":"   //定义一个错误的密码进行校验:false
    //            + passwordEncoder.matches("654321", encodedPassword));
    //}
}
