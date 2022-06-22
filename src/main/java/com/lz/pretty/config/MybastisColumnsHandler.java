package com.lz.pretty.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.lz.pretty.common.utils.JwtTokenUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Component
public class MybastisColumnsHandler implements MetaObjectHandler {

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

        this.strictInsertFill(metaObject, "createBy", String.class, jwtTokenUtil.getUsernameFromToken());
        this.strictUpdateFill(metaObject, "updateBy", String.class, jwtTokenUtil.getUsernameFromToken());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "updateBy", String.class, jwtTokenUtil.getUsernameFromToken());
    }
}
