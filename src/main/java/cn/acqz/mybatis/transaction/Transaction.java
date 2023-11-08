package cn.acqz.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description 事务接口
 * @date 2023/04/13
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;

}
