package top.trial.spring.service;

import top.trial.library.dbutils.entity.GameEntity;

import java.util.List;

/**
 * spring注解演示service层接口
 *
 * @author Gaoyx
 */
public interface AnnotationService {
    List<GameEntity> getAllGames();

    GameEntity getGameById(int id);

    void gameUpdate(GameEntity gameEntity);
}
