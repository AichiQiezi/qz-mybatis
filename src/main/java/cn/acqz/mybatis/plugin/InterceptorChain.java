package cn.acqz.mybatis.plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description 拦截器链
 * @date 2023/06/30
 */
public class InterceptorChain {

    private final List<Interceptor> interceptors = new ArrayList<>();

    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public List<Interceptor> getInterceptors(){
        return Collections.unmodifiableList(interceptors);
    }

}
