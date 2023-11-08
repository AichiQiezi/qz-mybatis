package cn.acqz.mybatis.transaction.jdbc;

import cn.acqz.mybatis.session.TransactionIsolationLevel;
import cn.acqz.mybatis.transaction.Transaction;
import cn.acqz.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @description JdbcTransaction 工厂
 * @date 2023/04/13
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }

}
