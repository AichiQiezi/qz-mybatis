package cn.acqz.mybatis.test;

import cn.acqz.mybatis.io.Resources;
import cn.acqz.mybatis.session.SqlSession;
import cn.acqz.mybatis.session.SqlSessionFactory;
import cn.acqz.mybatis.session.SqlSessionFactoryBuilder;
import cn.acqz.mybatis.test.po.Activity;
import cn.acqz.mybatis.session.*;
import cn.acqz.mybatis.test.dao.IActivityDao;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * @description 单元测试
 *  * https://louluan.blog.csdn.net/article/details/41280959
 *  * https://dude6.com/article/168362.html
 * @date 2023/3/26
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_queryActivityById() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // 2. 请求对象
        Activity req = new Activity();
        req.setActivityId(100001L);

        // 3. 第一组：SqlSession
        // 3.1 开启 Session
        SqlSession sqlSession01 = sqlSessionFactory.openSession();
        // 3.2 获取映射器对象
        IActivityDao dao01 = sqlSession01.getMapper(IActivityDao.class);
        logger.info("测试结果01：{}", JSON.toJSONString(dao01.queryActivityById(req)));
        sqlSession01.close();

        // 4. 第一组：SqlSession
        // 4.1 开启 Session
        SqlSession sqlSession02 = sqlSessionFactory.openSession();
        // 4.2 获取映射器对象
        IActivityDao dao02 = sqlSession02.getMapper(IActivityDao.class);
        logger.info("测试结果02：{}", JSON.toJSONString(dao02.queryActivityById(req)));
        sqlSession02.close();
        System.out.println(ArrayList.class);
    }

}