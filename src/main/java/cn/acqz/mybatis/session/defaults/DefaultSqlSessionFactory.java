package cn.acqz.mybatis.session.defaults;

import cn.acqz.mybatis.executor.Executor;
import cn.acqz.mybatis.session.SqlSession;
import cn.acqz.mybatis.session.SqlSessionFactory;
import cn.acqz.mybatis.mapping.Environment;
import cn.acqz.mybatis.session.Configuration;
import cn.acqz.mybatis.session.TransactionIsolationLevel;
import cn.acqz.mybatis.transaction.Transaction;
import cn.acqz.mybatis.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * @description 默认的 DefaultSqlSessionFactory
 * @date 2023/04/01
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }

}
