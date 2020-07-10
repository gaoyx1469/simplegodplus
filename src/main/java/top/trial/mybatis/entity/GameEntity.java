package top.trial.mybatis.entity;

/**
 * Game JavaBean
 * <p>
 * 演示mybatis单表CRUD操作
 *
 * @Author gaoyx1469
 * @Date 2020/7/10
 * @Version 1.0
 */
public class GameEntity {

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
