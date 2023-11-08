package cn.acqz.mybatis.datasource.pooled;

import cn.acqz.mybatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @description 有连接池的数据源工厂
 * @date 2023/04/22
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {

    public PooledDataSourceFactory() {
        this.dataSource = new PooledDataSource();
    }

}
