package cn.acqz.mybatis.session;

/**
 * @description 工厂模式接口，构建SqlSession的工厂
 * @date 2023/04/01
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
   SqlSession openSession();

}
