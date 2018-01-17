package com.pasq.config;

import com.pasq.common.xss.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;

/**
 * 为spring boot项目添加过滤器
 *
 * @author wwx
 * @email wangweixin@pasq.com
 * @date 2017年11月29日
 * @see XssFilter {@link XssFilter} 过滤器创建方式
 */
@Configuration
public class FilterConfig {
    /**
     * 设置自定义过滤器 XssFilter
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        /**
         * 自定义过滤器 XssFilter
         * @see XssFilter {@link XssFilter} 过滤器创建方式
         */
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*");
        registration.setName("xssFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }
}
