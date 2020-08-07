package top.trial.spring.aop.dao;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import top.trial.spring.aop.entity.LogEntity;

/**
 * @Author gaoyx1469
 * @Date 2020/8/7
 * @Version 1.0
 */
@Repository
public interface LogDao {

    @Update("INSERT INTO SGP_LOG (SL_ID,SL_VISIT_TIME,SL_USERNAME,SL_IP,SL_URL,SL_EXECUTION_TIME,SL_METHOD,SL_STT,SL_ERROR_CODE,SL_ERROR_MESSAGE) VALUES(#{id},#{visitTimeStr},#{username},#{ip},#{url},#{executionTime},#{method},#{status},#{errCode},#{errMessage})")
    void logging(LogEntity logEntity);

}
