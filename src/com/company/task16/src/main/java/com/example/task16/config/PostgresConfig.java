package com.example.task16.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Configuration
@ConfigurationProperties(prefix = "postgres")
@EnableConfigurationProperties
public class PostgresConfig {
    private String login;
    private String password;
    private String dbName;
}
