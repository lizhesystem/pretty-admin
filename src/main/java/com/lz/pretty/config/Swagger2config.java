package com.lz.pretty.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 类描述: swagger配置类
 *
 * @author Lz on 2022-06-17
 */
@EnableSwagger2
@Configuration
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class Swagger2config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("pretty-admin 管理系统")
                //false 则不能在浏览器访问，true为默认。
                .enable(true)
                .select()
                // 扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.lz.pretty.module.system.controller"))
                // 选择API路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // swagger ui 的标题
                .title("pretty-admin 集成 Swagger2")
                // 描述
                .description("pretty-admin")
                // 外链
                .termsOfServiceUrl("https://www.baidu.com")
                // 文档的版本信息
                .version("1.0")
                .build();
    }
}
