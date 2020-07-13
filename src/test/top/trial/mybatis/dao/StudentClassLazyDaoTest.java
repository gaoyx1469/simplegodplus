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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试一对一【多对一】懒加载
 *
 * @Author gaoyx1469
 * @Date 2020/7/13
 * @Version 1.0
 */
public class StudentClassLazyDaoTest {
    private InputStream conf;
    private SqlSession session;
    private StudentClassLazyDao dao;

    @Before
    public void init() throws IOException {
        conf = Resources.getResourceAsStream("MybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(conf);
        //设置自动提交
        //session = factory.openSession(true);
        session = factory.openSession();
        dao = session.getMapper(StudentClassLazyDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        conf.close();
        session.close();
    }

    /**
     * 测试多对一【一对一】懒加载，可以看到SQL分开查
     */
    @Test
    public void testGetAllStudents() {
        List<StudentEntity> students = dao.getAllStudents();
        for (StudentEntity student : students)
            System.out.println(student);
    }

    /**
     * 测试多对一【一对一】懒加载，可以看到SQL分开查
     */
    @Test
    public void testGetAllClasses() {
        List<ClassEntity> classes = dao.getAllClasses();
        for (ClassEntity classEntity : classes)
            System.out.println(classEntity);
    }
}
