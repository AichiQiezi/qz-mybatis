package cn.acqz.mybatis.executor.keygen;

import cn.acqz.mybatis.mapping.MappedStatement;
import cn.acqz.mybatis.executor.Executor;
import cn.acqz.mybatis.reflection.MetaObject;
import cn.acqz.mybatis.session.Configuration;
import cn.acqz.mybatis.type.TypeHandler;
import cn.acqz.mybatis.type.TypeHandlerRegistry;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @description 使用 JDBC3 Statement.getGeneratedKeys
 * @date 2023/6/23
 */
public class Jdbc3KeyGenerator implements KeyGenerator {

    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {

    }

    public void processBatch(MappedStatement ms, Statement stmt, List<Object> parameters) {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            final Configuration configuration = ms.getConfiguration();
            final TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            final String[] keyProperties = ms.getKeyProperties();
            final ResultSetMetaData rsmd = rs.getMetaData();
            TypeHandler<?>[] typeHandlers = null;
            if (keyProperties != null && rsmd.getColumnCount() >= keyProperties.length) {
                for (Object parameter : parameters) {
                    // there should be one row for each statement (also one for each parameter)
                    if (!rs.next()) {
                        break;
                    }
                    final MetaObject metaParam = configuration.newMetaObject(parameter);
                    if (typeHandlers == null) {
                        // 先取得类型处理器
                        typeHandlers = getTypeHandlers(typeHandlerRegistry, metaParam, keyProperties);
                    }
                    // 填充键值
                    populateKeys(rs, metaParam, keyProperties, typeHandlers);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting generated key or setting result to parameter object. Cause: " + e, e);
        }
    }

    private TypeHandler<?>[] getTypeHandlers(TypeHandlerRegistry typeHandlerRegistry, MetaObject metaParam, String[] keyProperties) {
        TypeHandler<?>[] typeHandlers = new TypeHandler<?>[keyProperties.length];
        for (int i = 0; i < keyProperties.length; i++) {
            if (metaParam.hasSetter(keyProperties[i])) {
                Class<?> keyPropertyType = metaParam.getSetterType(keyProperties[i]);
                TypeHandler<?> th = typeHandlerRegistry.getTypeHandler(keyPropertyType, null);
                typeHandlers[i] = th;
            }
        }
        return typeHandlers;
    }

    private void populateKeys(ResultSet rs, MetaObject metaParam, String[] keyProperties, TypeHandler<?>[] typeHandlers) throws SQLException {
        for (int i = 0; i < keyProperties.length; i++) {
            TypeHandler<?> th = typeHandlers[i];
            if (th != null) {
                Object value = th.getResult(rs, i + 1);
                metaParam.setValue(keyProperties[i], value);
            }
        }
    }

}
