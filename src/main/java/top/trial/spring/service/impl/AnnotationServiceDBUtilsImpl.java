package top.trial.spring.service.impl;

import org.springframework.stereotype.Component;
import top.trial.library.dbutils.entity.GameEntity;
import top.trial.spring.dao.AnnotationDao;
import top.trial.spring.service.AnnotationService;

import javax.annotation.Resource;
import java.util.List;

/**
 * spring注解演示service层实现类
 *
 * @author Gaoyx
 */
@Component(value = "allAnnotationService")
public class AnnotationServiceDBUtilsImpl implements AnnotationService {

    //@Autowired
    //@Qualifier("annotationDao")
    @Resource(name = "allAnnotationDao")
    private AnnotationDao annotationDao;


    @Override
    public List<GameEntity> getAllGames() {
        return annotationDao.getAllGames();
    }

    @Override
    public GameEntity getGameById(int id) {
        return annotationDao.getGameById(id);
    }

    @Override
    public void gameUpdate(GameEntity gameEntity) {
        annotationDao.gameUpdate(gameEntity);
    }
}
