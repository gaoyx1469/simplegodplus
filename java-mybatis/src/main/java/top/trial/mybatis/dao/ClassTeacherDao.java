package top.trial.mybatis.dao;

import top.trial.mybatis.entity.ClassEntity;
import top.trial.mybatis.entity.TeacherEntity;

import java.util.List;

/**
 * 演示mybatis多对多查询
 *
 * @Author gaoyx1469
 * @Date 2020/7/12
 * @Version 1.0
 */
public interface ClassTeacherDao {

    /**
     * 获取所有班级信息，班级信息中包含班级执教教师信息
     *
     * @return List<ClassEntity>
     */
    List<ClassEntity> getAllClasses();

    /**
     * 获取所有教师信息，教师信息中包含所教班级信息
     *
     * @return List<TeacherEntity>
     */
    List<TeacherEntity> getAllTeachers();
}
