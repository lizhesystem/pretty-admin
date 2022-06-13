package com.lz.pretty.util;

import com.lz.pretty.module.security.bean.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 类描述:JWT 工具类
 *
 * @author lz
 * @create 2022-06-13 17:00
 */
public class JwtTokenUtil {

    private JwtProperties jwtProperties;

    public JwtTokenUtil(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }


    /**
     * 生成token令牌
     *
     * @param username 用户
     * @param payloads 令牌中携带的附加信息
     * @return 令token牌
     */
    public String generateToken(String username,
                                Map<String, String> payloads) {
        int payloadSizes = payloads == null ? 0 : payloads.size();

        Map<String, Object> claims = new HashMap<>(payloadSizes + 2);
        claims.put("sub", username);
        claims.put("created", new Date());

        if (payloadSizes > 0) {
            for (Map.Entry<String, String> entry : payloads.entrySet()) {
                claims.put(entry.getKey(), entry.getValue());
            }
        }

        return generateToken(claims);
    }


    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token         令牌
     * @param usernameParam 用户唯一标志
     * @return 是否有效
     */
    public Boolean validateToken(String token, String usernameParam) {

        String username = getUsernameFromToken(token);
        return (username.equals(usernameParam) && !isTokenExpired(token));
    }


    /**
     * 从claims生成令牌,如果看不懂就看谁调用它
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + jwtProperties.getExpiration());
        return Jwts.builder().setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .compact();
    }

    /**
     * 从令牌中获取数据声明,如果看不懂就看谁调用它
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }


    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }


    /**
     * 从令牌中获取用户名，这个方法可以随时随地调用
     *
     * @return 用户名
     */
    public String getUsernameFromToken() {
        String username;
        try {
            RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            String jwtToken = request.getHeader(jwtProperties.getHeader());

            Claims claims = getClaimsFromToken(jwtToken);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
}

