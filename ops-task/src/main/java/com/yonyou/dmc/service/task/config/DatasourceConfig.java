package com.yonyou.dmc.service.task.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.dexcoder.dal.JdbcDao;
import com.dexcoder.dal.SimpleSqlFactory;
import com.dexcoder.dal.handler.DefaultMappingHandler;
import com.dexcoder.dal.spring.JdbcDaoImpl;

@Configuration
@EnableTransactionManagement
public class DatasourceConfig {
    @Autowired
    private Environment env;
    
    /**
     * MySQL数据源
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource dataSource() throws Exception{
        Properties dataSourceProps = new Properties();
        dataSourceProps.put("driverClassName", env.getProperty("mysql.driverClassName"));
        dataSourceProps.put("url", env.getProperty("mysql.task.url"));
        dataSourceProps.put("username", env.getProperty("mysql.task.username"));
        dataSourceProps.put("password", env.getProperty("mysql.task.password"));
        dataSourceProps.put("initialSize", env.getProperty("initialSize"));
        dataSourceProps.put("maxActive", env.getProperty("maxActive"));
        dataSourceProps.put("minIdle", env.getProperty("minIdle"));
        dataSourceProps.put("maxWait", env.getProperty("maxWait"));
        dataSourceProps.put("removeAbandoned", env.getProperty("removeAbandoned"));
        dataSourceProps.put("removeAbandonedTimeout", env.getProperty("removeAbandonedTimeout"));
        dataSourceProps.put("timeBetweenEvictionRunsMillis", env.getProperty("timeBetweenEvictionRunsMillis"));
        dataSourceProps.put("minEvictableIdleTimeMillis", env.getProperty("minEvictableIdleTimeMillis"));
        dataSourceProps.put("validationQuery", env.getProperty("validationQuery"));
        dataSourceProps.put("testWhileIdle", env.getProperty("testWhileIdle"));
        dataSourceProps.put("testOnBorrow", env.getProperty("testOnBorrow"));
        dataSourceProps.put("testOnReturn", env.getProperty("testOnReturn"));
        dataSourceProps.put("poolPreparedStatements", env.getProperty("poolPreparedStatements"));
        dataSourceProps.put("maxPoolPreparedStatementPerConnectionSize",env.getProperty("maxPoolPreparedStatementPerConnectionSize"));
        dataSourceProps.put("filters", env.getProperty("filters"));
        dataSourceProps.put("connectionProperties", env.getProperty("connectionProperties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(dataSourceProps);
        return dataSource;
    }
    
    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        return new JdbcTemplate(dataSource());
    }
    
    @Bean
    public JdbcDao jdbcDao(JdbcOperations jdbcOperations) throws Exception {
        JdbcDaoImpl jdbcDao = new JdbcDaoImpl(); 
        jdbcDao.setJdbcTemplate(jdbcOperations);
        jdbcDao.setSqlFactory(new SimpleSqlFactory());
        jdbcDao.setMappingHandler(new DefaultMappingHandler());
        return jdbcDao;
    }
    
    
}
