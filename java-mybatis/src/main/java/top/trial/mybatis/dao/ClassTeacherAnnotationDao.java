package top.trial.mybatis.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import top.trial.mybatis.entity.ClassEntity;
import top.trial.mybatis.entity.TeacherEntity;

import java.util.List;

/**
 * mybatis注解方式一对多【多对多】查询
 *
 * @Author gaoyx1469
 * @Date 2020/7/14
 * @Version 1.0
 */
public interface ClassTeacherAnnotationDao {

    /**
     * 获取所有班级信息，班级信息中包含班级执教教师信息
     *
     * @return List<ClassEntity>
     */
    @Select("SELECT * FROM SG_CLASS_INF ")
    @Results(
            id = "classTeacherMap",
            value = {
                    @Result(id = true, column = "SCI_ID", property = "classId"),
                    @Result(column = "SCI_NAME", property = "className"),
                    @Result(column = "SCI_DESCRIBE", property = "classDescribe"),
                    @Result(column = "SCI_ID", property = "classTeachers", many = @Many(
                            select = "top.trial.mybatis.dao.ClassTeacherAnnotationDao.getTeachersByClassId",
                            fetchType = FetchType.LAZY
                    ))
            }
    )
    List<ClassEntity> getAllClasses();

    /**
     * 根据班级id获取教师信息，教师信息中不包含所教班级信息
     *
     * @return List<TeacherEntity>
     */
    @Select("SELECT * FROM SG_CLASS_TEACHER_REL LEFT JOIN SG_TEACHER_INF ON SCTR_TID=STI_ID WHERE SCTR_CID = #{0}")
    @Results(
            id = "teacherMap",
            value = {
                    @Result(id = true, column = "STI_ID", property = "teacherId"),
                    @Result(column = "STI_NAME", property = "teacherName"),
                    @Result(column = "STI_DATE", property = "startTeachingDate"),
            }
    )
    List<TeacherEntity> getTeachersByClassId(int id);

    /**
     * 根据班级id获取班级信息，班级信息中包含教师信息
     *
     * @param id 班级id
     * @return ClassEntity
     */
    @Select("SELECT * FROM SG_CLASS_INF WHERE SCI_ID = #{0}")
    @ResultMap("classTeacherMap")
    ClassEntity getClassById(int id);
}
