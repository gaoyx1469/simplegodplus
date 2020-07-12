package top.trial.mybatis.entity;

import java.util.List;

/**
 * GameEntity查询条件封装类
 *
 * @Author gaoyx1469
 * @Date 2020/7/12
 * @Version 1.0
 */
public class GameEntityVls {

    private List<Integer> gameIds;

    public List<Integer> getGameIds() {
        return gameIds;
    }

    public void setGames(List<Integer> gameIds) {
        this.gameIds = gameIds;
    }
}
