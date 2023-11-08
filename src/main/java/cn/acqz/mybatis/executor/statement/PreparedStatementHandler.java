package cn.acqz.mybatis.executor.statement;

import cn.acqz.mybatis.executor.Executor;
import cn.acqz.mybatis.executor.keygen.KeyGenerator;
import cn.acqz.mybatis.mapping.BoundSql;
import cn.acqz.mybatis.mapping.MappedStatement;
import cn.acqz.mybatis.session.ResultHandler;
import cn.acqz.mybatis.session.RowBounds;

import java.sql.*;
import java.util.List;

/**
 * @description 预处理语句处理器（PREPARED）
 * @date 2023/4/28
 */
public class PreparedStatementHandler extends BaseStatementHandler{

    public PreparedStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, RowBounds rowBounds,  ResultHandler resultHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, rowBounds, resultHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        String sql = boundSql.getSql();
        return connection.prepareStatement(sql);
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        parameterHandler.setParameters((PreparedStatement) statement);
    }

    /**
     * step-11 新增修改方法
     */
    @Override
    public int update(Statement statement) throws SQLException {
        PreparedStatement ps = (PreparedStatement) statement;
        ps.execute();
        int rows = ps.getUpdateCount();
        Object parameterObject = boundSql.getParameterObject();
        KeyGenerator keyGenerator = mappedStatement.getKeyGenerator();
        keyGenerator.processAfter(executor, mappedStatement, ps, parameterObject);
        return rows;
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        PreparedStatement ps = (PreparedStatement) statement;
        ps.execute();
        return resultSetHandler.<E> handleResultSets(ps);
    }

}
