package top.trial.springsecurity.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.trial.springsecurity.domain.RoleDomain;

import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/8/6
 * @Version 1.0
 */
@Repository
public interface RoleDao {

    @Select("SELECT * FROM SGP_ROLE WHERE SR_ID IN (SELECT SURR_RID FROM SGP_USER_ROLE_REL WHERE SURR_UID=#{0})")
    @Results({
            @Result(id = true, column = "SR_ID", property = "id"),
            @Result(column = "SR_NAME", property = "name"),
            @Result(column = "SR_NAME", property = "nickname"),
            @Result(column = "SR_DESCRIBE", property = "describe")

    })
    List<RoleDomain> getRolesByUserId(String roleId);
}
