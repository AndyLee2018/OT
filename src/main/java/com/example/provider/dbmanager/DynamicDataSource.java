package com.example.provider.dbmanager;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * AbstractRoutingDataSource中维护了一个targetDataSources，里面存放可选用的数据源，
 * 将实现AbstractRoutingDataSource的组件注入IOC后，在连接数据源时该组件则会到targetDataSources获取应该选择的数据源，
 * 选择的依据为determineCurrentLookupKey()的返回值。
 */
public class DynamicDataSource extends AbstractRoutingDataSource implements InitializingBean {

    @Override
    protected Object determineCurrentLookupKey() {
        //dbType由DataSourceSwitchAop中的切面方法，从@DataSource中获取到之后set进去
        return DataSourceContextHolder.getDbType();
    }
}
