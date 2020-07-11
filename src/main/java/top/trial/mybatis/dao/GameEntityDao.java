package top.trial.mybatis.dao;

import top.trial.mybatis.entity.GameEntity;

import java.util.List;

/**
 * 演示mybatis单表CRUD
 *
 * @Author gaoyx1469
 * @Date 2020/7/10
 * @Version 1.0
 */
public interface GameEntityDao {

    //多笔查询操作
    List<GameEntity> getAllGames();

    //单条插入操作
    void addGame(GameEntity game);

    //单条删除操作
    void deleteGame(int gameId);

    //单条更新操作
    void updateGame(GameEntity game);

    //单笔查询操作
    GameEntity getGameById(int gameId);

    //根据name模糊查询操作
    List<GameEntity> getGamesByName(String name);
}
