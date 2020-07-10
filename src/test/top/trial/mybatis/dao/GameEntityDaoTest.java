package top.trial.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.trial.mybatis.dao.GameEntityDao;
import top.trial.mybatis.entity.GameEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试mybatis单表CRUD操作
 *
 * @Author gaoyx1469
 * @Date 2020/7/10
 * @Version 1.0
 */
public class GameEntityDaoTest {
    private InputStream conf;
    private SqlSession session;
    private GameEntityDao dao;

    @Before
    public void init() throws IOException {
        conf = Resources.getResourceAsStream("MybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(conf);
        session = factory.openSession();
        dao = session.getMapper(GameEntityDao.class);
    }

    @After
    public void destroy() throws IOException {
        conf.close();
        session.close();
    }

    @Test
    public void getAllGames() {
        List<GameEntity> games = dao.getAllGames();
        for (GameEntity game : games)
            System.out.println(game.toString());
    }

    @Test
    public void addGame() {
        GameEntity game = new GameEntity("神界2：原罪", "回合制神作");
        dao.addGame(game);
        session.commit();
    }
}
