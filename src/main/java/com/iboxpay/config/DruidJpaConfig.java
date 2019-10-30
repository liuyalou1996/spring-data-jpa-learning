package com.iboxpay.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "mysqlEntityManagerFactory", transactionManagerRef = "mysqlTransactionManager", basePackages = {
        "com.iboxpay.dao" })
public class DruidJpaConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "mysqlEntityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter(); //Hibernate的jpa供应适配器，Hibernate实体管理器的实现，实体管理器相当于数据库连接，进行数据库访问。
        vendorAdapter.setGenerateDdl(true);//设置在实体管理器初始化，创建和更新所有相关表后是否生成DDL
        vendorAdapter.setShowSql(true);//设置时候在日志或控制台中显示sql语句
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.ejb.naming_strategy",
                "org.hibernate.cfg.ImprovedNamingStrategy");//设置命名策略
        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.iboxpay.entity");//设置实体扫描的包路径
        factory.setJpaProperties(jpaProperties);
        factory.afterPropertiesSet();//完成所有属性设置后调用初始化方法
        return factory.getObject();
    }

    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager transactionManagerSecondary() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

}
