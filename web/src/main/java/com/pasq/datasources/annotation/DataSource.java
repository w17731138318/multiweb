package com.pasq.datasources.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * @author wwx
 * @email wangweixin@pasq.com
 * @date 2017年11月29日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
