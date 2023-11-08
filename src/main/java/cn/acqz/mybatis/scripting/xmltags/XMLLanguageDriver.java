package cn.acqz.mybatis.scripting.xmltags;

import cn.acqz.mybatis.executor.parameter.ParameterHandler;
import cn.acqz.mybatis.scripting.LanguageDriver;
import cn.acqz.mybatis.scripting.defaults.DefaultParameterHandler;
import cn.acqz.mybatis.scripting.defaults.RawSqlSource;
import cn.acqz.mybatis.mapping.BoundSql;
import cn.acqz.mybatis.mapping.MappedStatement;
import cn.acqz.mybatis.mapping.SqlSource;
import cn.acqz.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @description XML语言驱动器
 * @date 2023/5/17
 */
public class XMLLanguageDriver implements LanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType) {
        // 用XML脚本构建器解析
        XMLScriptBuilder builder = new XMLScriptBuilder(configuration, script, parameterType);
        return builder.parseScriptNode();
    }

    /**
     * step-12 新增方法，用于处理注解配置 SQL 语句
     */
    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        // 暂时不解析动态 SQL
        return new RawSqlSource(configuration, script, parameterType);
    }

    @Override
    public ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        return new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }

}