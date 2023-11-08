package cn.acqz.mybatis.session;

/**
 * @description 结果处理器
 * @date 2023/04/26
 */
public interface ResultHandler {

    /**
     * 处理结果
     */
    void handleResult(ResultContext context);

}
