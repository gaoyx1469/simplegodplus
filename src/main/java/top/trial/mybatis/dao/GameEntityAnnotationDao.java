package top.trial.mybatis.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.trial.mybatis.entity.GameEntity;

import java.util.List;

/**
 * mybatis单表注解CRUD
 *
 * @Author gaoyx1469
 * @Date 2020/7/13
 * @Version 1.0
 */
public interface GameEntityAnnotationDao {

    /**
     * 多笔查询操作，注意没有了resultMap，只好自己对应
     *
     * @return List<GameEntity>
     */
    @Select("SELECT SGI_ID AS 'gameId' ,SGI_NAME AS 'gameName',SGI_DESCRIBE AS 'gameDescribe' FROM SG_GAME_INFO ")
    List<GameEntity> getAllGames();


    /**
     * 根据名字模糊查询
     *
     * @param gameName 名称
     * @return List<GameEntity>
     */
    @Select("SELECT SGI_ID AS 'gameId' ,SGI_NAME AS 'gameName',SGI_DESCRIBE AS 'gameDescribe' FROM SG_GAME_INFO WHERE SGI_NAME LIKE #{name} ")
    List<GameEntity> getGamesByName(String gameName);


    /**
     * 查询数据条数
     *
     * @return
     */
    @Select("SELECT COUNT(*) FROM SG_GAME_INFO ")
    int getGameNumber();

    /**
     * 根据gameId查询单条数据
     *
     * @param gameId gameId
     * @return GameEntity
     */
    @Select("SELECT SGI_ID AS 'gameId' ,SGI_NAME AS 'gameName',SGI_DESCRIBE AS 'gameDescribe' FROM SG_GAME_INFO WHERE SGI_ID = #{id} ")
    GameEntity getGameById(int gameId);

    /**
     * 插入GAME
     *
     * @param game GameEntity
     */
    @Insert("INSERT INTO SG_GAME_INFO (SGI_NAME,SGI_DESCRIBE) VALUES (#{gameName},#{gameDescribe}) ")
    void addGame(GameEntity game);

    /**
     * 更新GAME
     *
     * @param game GameEntity
     */
    @Update("UPDATE SG_GAME_INFO SET SGI_NAME=#{gameName}, SGI_DESCRIBE = #{gameDescribe} WHERE SGI_ID = #{gameId}")
    void updateGame(GameEntity game);

    /**
     * 删除GAME
     *
     * @param gameId gameId
     */
    @Delete("DELETE FROM SG_GAME_INFO WHERE SGI_ID = #{id}")
    void deleteGame(int gameId);

}
