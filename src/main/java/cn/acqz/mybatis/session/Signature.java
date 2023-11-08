package cn.acqz.mybatis.session;


public @interface Signature {
    /**
     * intercept class
     */
    Class<?> type();

    /**
     * intercept method
     */
    String method();

    /**
     * the parameters of the intercept method
     */
    Class<?>[] args();

}
