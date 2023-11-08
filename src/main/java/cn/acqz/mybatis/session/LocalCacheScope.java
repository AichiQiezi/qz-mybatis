package cn.acqz.mybatis.session;

/**
 * @description 本地缓存机制；
 * SESSION 默认值，缓存一个会话中执行的所有查询
 * STATEMENT 本地会话仅用在语句执行上，对相同 SqlSession 的不同调用将不做数据共享
 * @date 2023/7/3
 */
public enum LocalCacheScope {
    SESSION,
    STATEMENT
}
