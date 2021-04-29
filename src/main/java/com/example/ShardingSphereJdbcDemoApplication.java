package com.example;

import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry(proxyTargetClass = true)
@SpringBootApplication(exclude = {SpringBootConfiguration.class, DataSourceAutoConfiguration.class})
public class ShardingSphereJdbcDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereJdbcDemoApplication.class, args);
    }
}
