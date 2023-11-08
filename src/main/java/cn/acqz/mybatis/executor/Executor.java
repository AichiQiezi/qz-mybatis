package cn.acqz.mybatis.executor;

import cn.acqz.mybatis.mapping.MappedStatement;
import cn.acqz.mybatis.session.ResultHandler;
import cn.acqz.mybatis.session.RowBounds;
import cn.acqz.mybatis.cache.CacheKey;
import cn.acqz.mybatis.mapping.BoundSql;
import cn.acqz.mybatis.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * @description 执行器
 * @date 2023/04/26
 */
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    int update(MappedStatement ms, Object parameter) throws SQLException;

    // 查询，含缓存
    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, CacheKey key, BoundSql boundSql) throws SQLException;

    // 查询
    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler) throws SQLException;

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);

    // 清理Session缓存
    void clearLocalCache();

    // 创建缓存 Key
    CacheKey createCacheKey(MappedStatement ms, Object parameterObject, RowBounds rowBounds, BoundSql boundSql);

    void setExecutorWrapper(Executor executor);

}