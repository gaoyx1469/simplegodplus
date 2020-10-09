package top.trial.mybatis.dao;

import top.trial.mybatis.entity.ClassEntity;
import top.trial.mybatis.entity.StudentEntity;

import java.util.List;

/**
 * 演示mybatis一对一【多对一】和多对多【一对多】的多表查询懒加载
 *
 * @Author gaoyx1469
 * @Date 2020/7/13
 * @Version 1.0
 */
public interface StudentClassLazyDao {

    /**
     * 获取所有student信息，包括student的班级信息
     *
     * @return students
     */
    List<StudentEntity> getAllStudents();

    /**
     * 根据id获取班级信息，不包括student的信息
     *
     * @return 班级信息
     */
    ClassEntity getClassById(int id);

    /**
     * 获取所有student信息，包括student的班级信息
     *
     * @return classes
     */
    List<ClassEntity> getAllClasses();

    /**
     * 根据班级id获取学生信息
     *
     * @return 学生信息
     */
    List<StudentEntity> getStudentsByClassId(int id);

}
