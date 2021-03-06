package com.pasq.datasources;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置多数据源
 * @author wwx
 * @email wangweixin@pasq.com
 * @date 2017年11月29日
 */
@Configuration
public class DynamicDataSourceConfig {
    /**
     * 初始化集合时尽力设置集合大小
     */
    private final int INITIAL_CAPACITY=10;
    
    
    @Bean
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource oneDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource twoDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource oneDataSource, DataSource twoDataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<>(INITIAL_CAPACITY);
        targetDataSources.put(DataSourceName.ONE, oneDataSource);
        targetDataSources.put(DataSourceName.TWO, twoDataSource);
        return new DynamicDataSource(oneDataSource, targetDataSources);
    }
}
