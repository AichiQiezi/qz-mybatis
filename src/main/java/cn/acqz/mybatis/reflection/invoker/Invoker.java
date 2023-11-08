package cn.acqz.mybatis.reflection.invoker;

/**
 * @description 调用者
 * @date 2023/5/2
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();

}
