package top.trial.spring.ioc.dao;

import top.trial.library.dbutils.entity.GameEntity;

import java.util.List;

/**
 * spring注解演示dao层接口
 *
 * @author Gaoyx
 */
public interface AnnotationDao {

    void gameUpdate(GameEntity gameEntity);

    GameEntity getGameById(int gameId);

    List<GameEntity> getAllGames();

}
