package com.example.provider.dbmanager;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据源切换注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String SOURCE_A = "SOURCE_A";
    String SOURCE_B = "SOURCE_B";
    String value() default SOURCE_A;
}
