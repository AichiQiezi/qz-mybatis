package cn.acqz.mybatis.builder;

import cn.acqz.mybatis.mapping.ParameterMapping;
import cn.acqz.mybatis.mapping.SqlSource;
import cn.acqz.mybatis.session.Configuration;
import cn.acqz.mybatis.mapping.BoundSql;

import java.util.List;

/**
 * @description 静态SQL源码
 * @date 2023/5/17
 */
public class StaticSqlSource implements SqlSource {

    private String sql;
    private List<ParameterMapping> parameterMappings;
    private Configuration configuration;

    public StaticSqlSource(Configuration configuration, String sql) {
        this(configuration, sql, null);
    }

    public StaticSqlSource(Configuration configuration, String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.configuration = configuration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(configuration, sql, parameterMappings, parameterObject);
    }

}
