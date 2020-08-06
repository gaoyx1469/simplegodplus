package top.trial.springsecurity.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.trial.springsecurity.domain.UserDomain;

/**
 * @Author gaoyx1469
 * @Date 2020/8/6
 * @Version 1.0
 */
@Repository
public interface UserInfoDao {

    @Select("SELECT * FROM SGP_USER WHERE SU_NAME = #{0}")
    @Results({
            @Result(id = true,column = "SU_ID",property = "id"),
            @Result(column = "SU_NAME",property = "name"),
            @Result(column = "SU_NICKNAME",property = "nickname"),
            @Result(column = "SU_MOBILE",property = "phoneNumber"),
            @Result(column = "SU_EMAIL",property = "email"),
            @Result(column = "SU_BIRTHDAY",property = ""),
            @Result(column = "SU_PASSWORD",property = "password"),
            @Result(column = "SU_STT",property = "status"),
            @Result(column = "SU_CREADATE",property = "createDate"),
            @Result(column = "SU_MODIDATE",property = "updateDate"),
            @Result(column = "SU_ID",property = "roles",many = @Many(
                    select = "top.trial.springsecurity.dao.RoleDao.getRolesByUserId"
            )),


    })
    UserDomain getUserByName(String username);

}
