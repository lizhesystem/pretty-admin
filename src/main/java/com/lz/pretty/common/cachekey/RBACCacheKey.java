package com.lz.pretty.common.cachekey;

/**
 * 类描述: 缓存常量
 * 用途：每次鉴权都要去数据库获取当前用户的权限信息，放到缓存里直接从缓存里获取
 *
 * @author Lz on 2022-06-23
 */
public class RBACCacheKey {

    // 用户信息缓存(用于JWT用户登录验证及接口权限验证)，缓存策略：key=用户名
    // 用户信息被修改、删除、重置修改密码的时候，清除该缓存。 缓存清除策略：key=用户名
    public static final String USER_DETAIL = "user_detail";

}
