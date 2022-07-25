package com.lz.pretty.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 类描述: 项目相关配置 *
 *
 * @author Lz on 2022-07-25
 */
@Component
@Data
@ConfigurationProperties(prefix = "pretty.config")
public class PrettyConfig {

    // 本地上传文件路径
    private String profile;
}
