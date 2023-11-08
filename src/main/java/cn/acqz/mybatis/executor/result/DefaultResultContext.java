package cn.acqz.mybatis.executor.result;

import cn.acqz.mybatis.session.ResultContext;

/**
 * @description 默认结果上下文
 * @date 2023/05/31
 */
public class DefaultResultContext implements ResultContext {

    private Object resultObject;
    private int resultCount;

    public DefaultResultContext() {
        this.resultObject = null;
        this.resultCount = 0;
    }

    @Override
    public Object getResultObject() {
        return resultObject;
    }

    @Override
    public int getResultCount() {
        return resultCount;
    }

    public void nextResultObject(Object resultObject) {
        resultCount++;
        this.resultObject = resultObject;
    }

}
