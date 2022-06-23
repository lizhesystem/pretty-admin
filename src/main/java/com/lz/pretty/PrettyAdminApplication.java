package com.lz.pretty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 类描述:
 *
 * @author lz
 * @create 2022-06-13 10:51
 */
@EnableCaching
@SpringBootApplication
@MapperScan(basePackages = {"com.lz.**.mapper"})
public class PrettyAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrettyAdminApplication.class, args);
    }
}
