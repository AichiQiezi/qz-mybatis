package cn.acqz.mybatis.scripting.defaults;

import cn.acqz.mybatis.builder.SqlSourceBuilder;
import cn.acqz.mybatis.mapping.BoundSql;
import cn.acqz.mybatis.mapping.SqlSource;
import cn.acqz.mybatis.scripting.xmltags.DynamicContext;
import cn.acqz.mybatis.scripting.xmltags.SqlNode;
import cn.acqz.mybatis.session.Configuration;

import java.util.HashMap;

/**
 * @description 原始SQL源码，比 DynamicSqlSource 动态SQL处理快
 * @date 2023/5/17
 */
public class RawSqlSource implements SqlSource {

    private final SqlSource sqlSource;

    public RawSqlSource(Configuration configuration, SqlNode rootSqlNode, Class<?> parameterType) {
        this(configuration, getSql(configuration, rootSqlNode), parameterType);
    }

    public RawSqlSource(Configuration configuration, String sql, Class<?> parameterType) {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
        Class<?> clazz = parameterType == null ? Object.class : parameterType;
        sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<>());
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return sqlSource.getBoundSql(parameterObject);
    }

    private static String getSql(Configuration configuration, SqlNode rootSqlNode) {
        DynamicContext context = new DynamicContext(configuration, null);
        rootSqlNode.apply(context);
        return context.getSql();
    }

}
