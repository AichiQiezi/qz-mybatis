package cn.acqz.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @description 数据源工厂
 * @date 2023/04/13
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();

}
