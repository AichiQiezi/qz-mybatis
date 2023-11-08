package cn.acqz.mybatis.executor.keygen;

import cn.acqz.mybatis.executor.Executor;
import cn.acqz.mybatis.mapping.MappedStatement;

import java.sql.Statement;

/**
 * @description 不用键值生成器
 * @date 2023/6/23
 */
public class NoKeyGenerator implements KeyGenerator{

    @Override
    public void processBefore(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

    @Override
    public void processAfter(Executor executor, MappedStatement ms, Statement stmt, Object parameter) {
        // Do Nothing
    }

}
