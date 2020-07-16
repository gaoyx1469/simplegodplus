package top.trial.library.dbutils.entity;

import java.io.Serializable;

/**
 * Game JavaBean
 * <p>
 * 操作dbutils时使用的实体类
 *
 * @Author gaoyx1469
 * @Date 2020/7/16
 * @Version 1.0
 */
public class GameEntity implements Serializable {

    private int gameId;
    private String gameName;
    private String gameDescribe;

    public GameEntity() {
    }

    public GameEntity(String gameName, String gameDescribe) {
        this.gameName = gameName;
        this.gameDescribe = gameDescribe;
    }

    public GameEntity(int gameId, String gameName, String gameDescribe) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameDescribe = gameDescribe;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDescribe() {
        return gameDescribe;
    }

    public void setGameDescribe(String gameDescribe) {
        this.gameDescribe = gameDescribe;
    }

    @Override
    public String toString() {
        return "GameEntity{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                ", gameDescribe='" + gameDescribe + '\'' +
                '}';
    }
}
