package top.trial.mybatis.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.trial.mybatis.entity.ClassEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试mybatis单表查询注解操作
 *
 * @Author gaoyx1469
 * @Date 2020/7/13
 * @Version 1.0
 */
@CacheNamespace(blocking = true)
public class ClassTeacherAnnotationDaoTest {
    private InputStream conf;
    private SqlSession session;
    private ClassTeacherAnnotationDao dao;

    @Before
    public void init() throws IOException {
        conf = Resources.getResourceAsStream("top/trial/mybatis/MybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(conf);
        //设置自动提交
        //session = factory.openSession(true);
        session = factory.openSession();
        dao = session.getMapper(ClassTeacherAnnotationDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        conf.close();
        session.close();
    }

    @Test
    public void testGetAllClasses() {
        List<ClassEntity> classes = dao.getAllClasses();
        for (ClassEntity classEntity : classes)
            System.out.println(classEntity);
    }

    @Test
    public void testGetClassById() {
        System.out.println(dao.getClassById(10001));
    }

}
