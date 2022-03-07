package com.example.task16.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Component
public class Сonfig {
    @Autowired
    private PostgresConfig postgresConfig;
    @Bean
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://127.0.0.1/" + postgresConfig.getDbName());
        config.setUsername(postgresConfig.getLogin());
        config.setPassword(postgresConfig.getPassword());
        return new HikariDataSource(config);
    }
    @Bean
    public LocalSessionFactoryBean factoryBean(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("com.example.task16.entity");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }
    @Bean
    public PlatformTransactionManager
    platformTransactionManager(LocalSessionFactoryBean factoryBean){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(factoryBean.getObject());
        return transactionManager;
    }
}
