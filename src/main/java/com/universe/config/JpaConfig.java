package com.universe.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@EnableJpaRepositories("com.universe.repository")
@EnableTransactionManagement
public class JpaConfig {

  @ConfigurationProperties(prefix = "spring.datasource.druid")
  @Bean(initMethod = "init", destroyMethod = "close")
  public DruidDataSource druidDataSource() {
    return DruidDataSourceBuilder.create().build();
  }

  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource druidDataSource) {
    // Hibernate的jpa供应适配器，Hibernate实体管理器的实现，实体管理器相当于数据库连接，进行数据库访问
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    // 设置在实体管理器初始化，创建和更新所有相关表后是否生成DDL
    vendorAdapter.setGenerateDdl(false);
    // 设置时候在日志或控制台中显示sql语句
    vendorAdapter.setShowSql(true);

    Properties properties = new Properties();
    // 设置命名策略，5.0以后不再起作用
    // properties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
    properties.put("hibernate.hbm2ddl.auto", "none");
    // 用Spring物理命名策略，如实体User转物理表名user，实体属性userId转物理列名user_id，但注解优先配置
    properties.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");

    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setJpaVendorAdapter(vendorAdapter);
    factoryBean.setDataSource(druidDataSource);
    factoryBean.setPackagesToScan("com.universe.entity");
    factoryBean.setJpaProperties(properties);
    return factoryBean;
  }

  @Bean(name = "transactionManager")
  public PlatformTransactionManager transactionManagerSecondary(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

}
