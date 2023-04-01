package com.example.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @who luhaoming
 * @when 2020/7/27 15:15
 * @what 数据源配置
 */
@SuppressWarnings("ALL")
@Configuration
@Slf4j
@MapperScan(basePackages = {"com.example.demo.dao"}, sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfig {

    @Autowired
    private DataSourceConfig dataSourceConfig;

    @Bean(name = "dataSource", destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource.demo")
    public DataSource setDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        // 数据库
        properties.setProperty("helperDialect", "mysql");
        // 是否将参数offset作为PageNum使用
        properties.setProperty("offsetAsPageNum", "true");
        // 是否进行count查询
        properties.setProperty("reasonable", "false");
        interceptor.setProperties(properties);
        bean.setPlugins(interceptor);

        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:/mybatis/mapper/*.xml"));
        if (bean.getObject() != null) {
            bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        }
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
