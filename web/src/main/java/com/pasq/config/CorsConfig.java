package com.pasq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 允许跨域
 * 此拦截器可以移至 WebMvcConfig 配置类中
 * @see WebMvcConfig
 * @author 王伟鑫
 * @email wangweixin@pasq.com
 * @date 2017年11月29日
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
    /**
     * {@link CorsRegistry}
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }
}
