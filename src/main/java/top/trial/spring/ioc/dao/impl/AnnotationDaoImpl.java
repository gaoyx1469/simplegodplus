package top.trial.spring.ioc.dao.impl;

import org.springframework.stereotype.Repository;

import top.trial.library.dbutils.entity.GameEntity;
import top.trial.spring.ioc.dao.AnnotationDao;

import java.util.List;

/**
 * spring注解演示dao层实现类
 *
 * @author Gaoyx
 */
@Repository(value = "annotationDao")
public class AnnotationDaoImpl implements AnnotationDao {

    @Override
    public void gameUpdate(GameEntity gameEntity) {
        System.out.println("调用了game的update方法");
    }

    @Override
    public GameEntity getGameById(int gameId) {
        System.out.println("调用了game的getAll方法");
        return null;
    }

    @Override
    public List<GameEntity> getAllGames() {
        System.out.println("调用了game的getById方法");
        return null;
    }

}
