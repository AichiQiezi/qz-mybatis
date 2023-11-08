package cn.acqz.mybatis.reflection.wrapper;

import cn.acqz.mybatis.reflection.MetaObject;

/**
 * @description 对象包装工厂
 * @date 2023/5/2
 */
public interface ObjectWrapperFactory {

    /**
     * 判断有没有包装器
     */
    boolean hasWrapperFor(Object object);

    /**
     * 得到包装器
     */
    ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);

}
