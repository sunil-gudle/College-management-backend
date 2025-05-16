package com.dailycoding.restful_service.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MySQLConfig {


    @Primary
    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSource mysqlDataSource(){
        return  new HikariDataSource();
    }
}
