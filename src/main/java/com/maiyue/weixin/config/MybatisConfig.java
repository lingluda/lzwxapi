package com.maiyue.weixin.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by huang on 2017/12/21.
 */
@Configuration
@EnableTransactionManagement
@AutoConfigureAfter({DruidConfig.class })
@ConfigurationProperties(prefix = "mybatis")
@MapperScan(basePackages={"com.maiyue.**.mapper"})
public class MybatisConfig {

   private Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

    @Resource(name="druidDataSource")
    private DataSource druidDataSource;

    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;
    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;
    @Value("${mybatis.configLocation}")
    private String configLocation;

    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory() {
        try {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(druidDataSource);
            sessionFactory.setTypeAliasesPackage(typeAliasesPackage);
            sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                            .getResources(mapperLocations));
            sessionFactory.setConfigLocation(new DefaultResourceLoader()
                            .getResource(configLocation));

            return sessionFactory.getObject();
        } catch (Exception e) {
            logger.warn("Could not confiure mybatis session factory");
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    @ConditionalOnMissingBean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(druidDataSource);
    }
}
