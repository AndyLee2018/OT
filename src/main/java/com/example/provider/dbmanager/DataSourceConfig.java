package com.example.provider.dbmanager;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
@Configuration
public class DataSourceConfig {

    @Bean(name="SOURCE_A")
    @ConfigurationProperties(prefix = "spring.datasource.a")
    public DataSource sourceOne(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="SOURCE_B")
    @ConfigurationProperties(prefix = "spring.datasource.b")
    public DataSource sourceTwo(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DataSource dynamicDataSource(){
        /**
         * 动态数据源的开发就是围绕DynamicDataSource的开发，它需要维护可选择的数据源以及应该用哪个数据源，
         * 这里设定的就是可选择的数据源，切面方法里根据注解设定了应取的数据源
         */
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(sourceOne());
        HashMap<Object, Object> targetMap = new HashMap<>();
        targetMap.put("SOURCE_A",sourceOne());
        targetMap.put("SOURCE_B",sourceTwo());
        dynamicDataSource.setTargetDataSources(targetMap);
        return dynamicDataSource;
    }
}
