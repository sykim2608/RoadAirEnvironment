package com.ntels.sykim.RoadAirEnvironment.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;

/**
 * DataBase 설정
 * @author sykim@ntels.com
 */
@Configuration
@MapperScan(basePackages = "com.ntels.sykim.RoadAirEnvironment.dao")
public class DatabaseConfig {
    /**
     * Application Context
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Sql Session Factory
     * @param dataSource
     * @return Object
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("mapper/*.xml");
        sqlSessionFactoryBean.setMapperLocations(res);
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * Sql Session Template
     * @param sqlSessionFactory
     * @return SqlSessionTemplate
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
