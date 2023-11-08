package cn.acqz.mybatis.session;

/**
 * @description 结果上下文
 * @date 2023/05/31
 */
public interface ResultContext {

    /**
     * 获取结果
     */
    Object getResultObject();

    /**
     * 获取记录数
     */
    int getResultCount();

}
