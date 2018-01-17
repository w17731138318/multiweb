package com.pasq.config;

import com.pasq.common.handler.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * MVC配置
 * 配置拦截器：Spring 为此提供了基础类WebMvcConfigurerAdapter ，我们只需要重写addInterceptors 方法添加注册拦截器
 * @author wwx
 * @email wangweixin@pasq.com
 * @date 2017年11月29日
 * @see WebMvcConfigurerAdapter
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * @see MyHandler 自定义的拦截器
     */
    @Autowired
    private MyHandler myHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 为spring boot 项目添加拦截器
         * {@link MyHandler}
         */
        registry.addInterceptor(myHandler).addPathPatterns("/**");
    }

    /**
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 自定义目录 ResourceHandlerRegistry
         */
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/images/");
        /**
         * 使用绝对路径
         */
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:d:/images/");
        /**
         * 使用webjars
         */

    }


}