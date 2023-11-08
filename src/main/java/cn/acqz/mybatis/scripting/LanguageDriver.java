package cn.acqz.mybatis.scripting;

import cn.acqz.mybatis.executor.parameter.ParameterHandler;
import cn.acqz.mybatis.mapping.BoundSql;
import cn.acqz.mybatis.mapping.MappedStatement;
import cn.acqz.mybatis.mapping.SqlSource;
import cn.acqz.mybatis.session.Configuration;
import org.dom4j.Element;

/**
 * @description 脚本语言驱动
 * @date 2023/5/17
 */
public interface LanguageDriver {

    /**
     * 创建SQL源码(mapper xml方式)
     */
    SqlSource createSqlSource(Configuration configuration, Element script, Class<?> parameterType);

    /**
     * 创建SQL源码(annotation 注解方式)
     */
    SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType);

    /**
     * 创建参数处理器
     */
    ParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql);

}
