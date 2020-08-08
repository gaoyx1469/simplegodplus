package top.trial.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.trial.mybatis.entity.GameEntity;
import top.trial.mybatis.entity.GameEntityVls;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        conf = Resources.getResourceAsStream("top/trial/mybatis/MybatisConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(conf);
        //设置自动提交
        //session = factory.openSession(true);
        session = factory.openSession();
        dao = session.getMapper(GameEntityDao.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
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
        GameEntity game = new GameEntity(15, "神界2：原罪", "回合制神作");
        dao.addGame(game);
        System.out.println(game.toString());//自增主键注入game中
    }

    @Test
    public void deleteGame() {
        dao.deleteGame(18);
    }

    @Test
    public void updateGame() {
        GameEntity game = new GameEntity(10, "GTA5", "NB");
        dao.updateGame(game);
    }

    @Test
    public void getGameById() {
        System.out.println(dao.getGameById(7));
    }

    @Test
    public void getGamesByName() {
        List<GameEntity> games = dao.getGamesByName("%2%");
        for (GameEntity game : games)
            System.out.println(game.toString());
    }

    @Test
    public void getGamesByProp() {
        GameEntity gameEntity = new GameEntity();
        gameEntity.setGameName("神界2：原罪");
        //此处不同属性set语句轮流注释试试if条件
        //gameEntity.setGameId(8);
        //gameEntity.setGameDescribe("回合制神作");
        List<GameEntity> games = dao.getGamesByProp(gameEntity);
        for (GameEntity game : games)
            System.out.println(game.toString());
    }

    @Test
    public void getGamesByIds() {
        List<Integer> gameIds = new ArrayList<>();
        //gameIds.add(6);
        //gameIds.add(7);
        //gameIds.add(8);
        GameEntityVls gameEntityVls = new GameEntityVls();
        gameEntityVls.setGames(gameIds);
        List<GameEntity> games = dao.getGamesByIds(gameEntityVls);
        for (GameEntity game : games)
            System.out.println(game.toString());
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testGetGameByIdCache() {
        GameEntity game1 = dao.getGameById(5);
        System.out.println(game1);

        //清空缓存
        //session.clearCache();

        GameEntity game2 = dao.getGameById(5);
        System.out.println(game2);

        System.out.println(game1 == game2);

    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testGetGameByIdCacheII() {

        SqlSession session1 = factory.openSession();
        GameEntityDao dao1 = session1.getMapper(GameEntityDao.class);
        GameEntity game1 = dao1.getGameById(5);
        System.out.println(game1);

        //session1不close的话，没有使用二级缓存
        session1.close();
        //清空缓存
        //session.clearCache();

        SqlSession session2 = factory.openSession();
        GameEntityDao dao2 = session2.getMapper(GameEntityDao.class);
        GameEntity game2 = dao2.getGameById(5);
        System.out.println(game2);

        System.out.println(game1 == game2);

    }
}
