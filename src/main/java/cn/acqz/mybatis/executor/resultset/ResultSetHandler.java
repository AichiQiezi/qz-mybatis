package cn.acqz.mybatis.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @description 结果集处理器
 * @date 2023/04/26
 */
public interface ResultSetHandler {

    <E> List<E> handleResultSets(Statement stmt) throws SQLException;

}
