package top.trial.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.trial.mybatis.entity.GameEntity;

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
public class GameEntityAnnotationDaoTest {
    private InputStream conf;
    private SqlSession session;
    private GameEntityAnnotationDao dao;

    @Before
    public void init() throws IOException {
        conf = Resources.getResourceAsStream("MybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(conf);
        //设置自动提交
        //session = factory.openSession(true);
        session = factory.openSession();
        dao = session.getMapper(GameEntityAnnotationDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        conf.close();
        session.close();
    }

    @Test
    public void testGetAllGames() {
        List<GameEntity> games = dao.getAllGames();
        for (GameEntity game : games)
            System.out.println(game);
    }

    @Test
    public void testGetGamesByName() {
        List<GameEntity> games = dao.getGamesByName("%山%");
        for (GameEntity game : games)
            System.out.println(game);
    }

    @Test
    public void testGetGameNumber() {
        System.out.println(dao.getGameNumber());
    }

    @Test
    public void testGetGameById() {
        System.out.println(dao.getGameById(15));
    }

    @Test
    public void testAddGame() {
        GameEntity gameEntity = new GameEntity("农场19", "种菜");
        dao.addGame(gameEntity);
    }

    @Test
    public void testUpdateGame() {
        GameEntity gameEntity = new GameEntity(15, "凤凰火", "跟幽浮差不多么");
        dao.updateGame(gameEntity);
    }

    @Test
    public void testDeleteGame() {
        dao.deleteGame(16);
    }

}
