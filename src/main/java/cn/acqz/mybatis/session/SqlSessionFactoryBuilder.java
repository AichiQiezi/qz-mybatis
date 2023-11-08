package cn.acqz.mybatis.session;

import cn.acqz.mybatis.builder.xml.XMLConfigBuilder;
import cn.acqz.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @description 构建SqlSessionFactory的工厂
 * @date 2023/04/06
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
