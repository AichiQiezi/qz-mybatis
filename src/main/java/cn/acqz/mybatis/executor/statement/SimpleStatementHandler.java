package cn.acqz.mybatis.executor.statement;

import cn.acqz.mybatis.executor.Executor;
import cn.acqz.mybatis.mapping.BoundSql;
import cn.acqz.mybatis.mapping.MappedStatement;
import cn.acqz.mybatis.session.ResultHandler;
import cn.acqz.mybatis.session.RowBounds;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @description 简单语句处理器（STATEMENT）
 * @date 2023/04/26
 */
public class SimpleStatementHandler extends BaseStatementHandler {

    public SimpleStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, rowBounds, resultHandler, boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        // N/A
    }

    @Override
    public int update(Statement statement) throws SQLException {
        String sql = boundSql.getSql();
        statement.execute(sql);
        return statement.getUpdateCount();
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        String sql = boundSql.getSql();
        statement.execute(sql);
        return resultSetHandler.handleResultSets(statement);
    }

}
