package com.dailycoding.restful_service.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class H2Config {

    @Bean(name = "h2DataSource")
    @ConfigurationProperties("spring.datasource.h2")
    public DataSource h2DataSource(){
        return new HikariDataSource();
    }
}
