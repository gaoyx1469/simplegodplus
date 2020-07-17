package top.trial.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.trial.mybatis.entity.ClassEntity;
import top.trial.mybatis.entity.StudentEntity;
import top.trial.mybatis.entity.TeacherEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试mybatis多对多操作
 *
 * @Author gaoyx1469
 * @Date 2020/7/12
 * @Version 1.0
 */
public class ClassTeacherDaoTest {
    private InputStream conf;
    private SqlSession session;
    private ClassTeacherDao dao;

    @Before
    public void init() throws IOException {
        conf = Resources.getResourceAsStream("top/trial/mybatis/MybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(conf);
        //设置自动提交
        //session = factory.openSession(true);
        session = factory.openSession();
        dao = session.getMapper(ClassTeacherDao.class);
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
    public void testGetAllTeachers() {
        List<TeacherEntity> teachers = dao.getAllTeachers();
        for (TeacherEntity teacher : teachers)
            System.out.println(teacher);
    }
}
