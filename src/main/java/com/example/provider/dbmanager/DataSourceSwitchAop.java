package com.example.provider.dbmanager;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Order(0)
@Aspect
@Component
public class DataSourceSwitchAop {

    @Pointcut("@annotation(com.example.provider.dbmanager.DataSource)")
    public void chooseDataSource(){}

    @Before(value = "chooseDataSource()")
    public void beforeInvoke(JoinPoint joinPoint){
        String clazzName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Class<?> clazz = null;
        try {
            clazz = Class.forName(clazzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if(method.getName().equals(methodName)){
                if(method.isAnnotationPresent(DataSource.class)){
                    DataSource annotation = method.getAnnotation(DataSource.class);
                    DataSourceContextHolder.setDbType(annotation.value());
                }
            }
        }
    }

    @After(value = "chooseDataSource()")
    public void afterInvoke(JoinPoint joinPoint){
        DataSourceContextHolder.clearType();
    }
}
