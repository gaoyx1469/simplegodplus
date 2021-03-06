package top.trial.mybatis.dao;

import top.trial.mybatis.entity.GameDirectEntity;

import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/7/9
 * @Version 1.0
 */
public interface GameDirectEntityDao {

    /**
     * 获取所有game
     *
     * @return List<GameDirectEntity>
     */
    List<GameDirectEntity> getAllGames();

}
