package top.trial.mybatis.dao;

import top.trial.mybatis.entity.StudentEntity;

import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/7/12
 * @Version 1.0
 */
public interface StudentClassDao {

    /**
     * 获取所有student信息，包括student的班级信息
     *
     * @return student
     */
    List<StudentEntity> getAllStudents();

}
