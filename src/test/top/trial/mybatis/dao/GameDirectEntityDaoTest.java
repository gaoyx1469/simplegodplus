package top.trial.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.trial.mybatis.entity.GameDirectEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/7/10
 * @Version 1.0
 */
public class GameDirectEntityDaoTest {

    /**
     * mybatis入门案例测试
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //读取配置文件【Resources是mybatis自己的工具类】
        InputStream conf = Resources.getResourceAsStream("MybatisConfig.xml");
        //创建工厂SqlSessionFactory【建造者模式，根据字节输入流构建SqlSessionFactory】
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(conf);
        //使用工厂生产SqlSession对象【工厂模式，解耦】
        SqlSession session = factory.openSession();
        //使用SqlSession创建接口的动态代理对象【代理模式，解耦，增强】
        GameDirectEntityDao gameDao = session.getMapper(GameDirectEntityDao.class);
        //使用代理对象执行方法
        List<GameDirectEntity> games = gameDao.getAllGames();
        for (GameDirectEntity game : games) {
            System.out.println(game.toString());
        }
        //释放资源
        session.close();
        conf.close();
    }

}
