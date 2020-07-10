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
}
