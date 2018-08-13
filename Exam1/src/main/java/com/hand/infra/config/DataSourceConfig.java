package com.hand.infra.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
public class DataSourceConfig {
    @Autowired
    private Environment env;

    @Bean
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("URL"));
        dataSource.setUsername(env.getProperty("USERNAME"));
        dataSource.setPassword(env.getProperty("PASSWORD"));
        dataSource.setDriverClassName(env.getProperty("DRIVERCLASSNAME"));
        return dataSource;
    }
}