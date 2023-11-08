package cn.acqz.mybatis.reflection.wrapper;

import cn.acqz.mybatis.reflection.MetaObject;

/**
 * @description 默认对象包装工厂
 * @date 2023/5/2
 */
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory{

    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new RuntimeException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }

}
