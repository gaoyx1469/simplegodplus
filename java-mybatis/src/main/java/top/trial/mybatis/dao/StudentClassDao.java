package top.trial.mybatis.dao;

import top.trial.mybatis.entity.ClassEntity;
import top.trial.mybatis.entity.StudentEntity;

import java.util.List;

/**
 * 演示mybatis一对一【多对一】和一对多的多表查询
 *
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

    /**
     * 获取所有班级信息，包括班级的student信息
     *
     * @return class
     */
    List<ClassEntity> getAllClasses();

}
