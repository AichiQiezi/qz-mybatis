package cn.acqz.mybatis.mapping;

import cn.acqz.mybatis.session.Configuration;
import cn.acqz.mybatis.type.JdbcType;
import cn.acqz.mybatis.type.TypeHandler;
import cn.acqz.mybatis.type.TypeHandlerRegistry;

/**
 * @description 参数映射 #{property,javaType=int,jdbcType=NUMERIC}
 * @date 2023/04/12
 */
public class ParameterMapping {

    private Configuration configuration;

    // property
    private String property;
    // javaType = int
    private Class<?> javaType = Object.class;
    // jdbcType=NUMERIC
    private JdbcType jdbcType;
    private TypeHandler<?> typeHandler;

    private ParameterMapping() {
    }

    public static class Builder {

        private ParameterMapping parameterMapping = new ParameterMapping();

        public Builder(Configuration configuration, String property, Class<?> javaType) {
            parameterMapping.configuration = configuration;
            parameterMapping.property = property;
            parameterMapping.javaType = javaType;
        }

        public Builder javaType(Class<?> javaType) {
            parameterMapping.javaType = javaType;
            return this;
        }

        public Builder jdbcType(JdbcType jdbcType) {
            parameterMapping.jdbcType = jdbcType;
            return this;
        }

        public ParameterMapping build() {
            if (parameterMapping.typeHandler == null && parameterMapping.javaType != null) {
                Configuration configuration = parameterMapping.configuration;
                TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
                parameterMapping.typeHandler = typeHandlerRegistry.getTypeHandler(parameterMapping.javaType, parameterMapping.jdbcType);
            }

            return parameterMapping;
        }

    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public String getProperty() {
        return property;
    }

    public Class<?> getJavaType() {
        return javaType;
    }

    public JdbcType getJdbcType() {
        return jdbcType;
    }

    public TypeHandler<?> getTypeHandler() {
        return typeHandler;
    }

}
