package cn.acqz.mybatis.mapping;

/**
 * @description SQL源码
 * @date 2023/5/17
 */
public interface SqlSource {

    BoundSql getBoundSql(Object parameterObject);

}
