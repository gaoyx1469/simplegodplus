package top.trial.mybatis.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import top.trial.mybatis.entity.ClassEntity;
import top.trial.mybatis.entity.StudentEntity;

import java.util.List;

/**
 * mybatis注解方式一对一【多对一】查询
 *
 * @Author gaoyx1469
 * @Date 2020/7/14
 * @Version 1.0
 */
public interface StudentClassAnnotationDao {

    /**
     * 查询所有学生，附带查询学生班级信息
     * <p>
     * 注意@one标签
     *
     * @return List<StudentEntity>
     */
    @Select("SELECT * FROM SG_STUDENT_INF ")
    @Results(
            id = "studentClassMap",
            value = {
                    @Result(id = true, column = "SSI_ID", property = "studentId"),
                    @Result(column = "SSI_NAME", property = "studentName"),
                    @Result(column = "SSI_AGE", property = "studentAge"),
                    @Result(column = "SSI_GENDER", property = "studentSex"),
                    @Result(column = "SSI_CID", property = "studentClass",
                            one = @One(select = "top.trial.mybatis.dao.StudentClassAnnotationDao.getClassById", fetchType = FetchType.EAGER))

            }
    )
    List<StudentEntity> getAllStudents();


    /**
     * 根据id查询学生，附带查询学生班级信息
     *
     * @param id 学生id
     * @return StudentEntity
     */
    @ResultMap("studentClassMap")
    @Select("SELECT * FROM SG_STUDENT_INF WHERE SSI_ID = #{0} ")
    StudentEntity getStudentById(int id);


    /**
     * 根据id查询班级，不附带查询学生班级信息
     *
     * @param id 学生id
     * @return ClassEntity
     */
    @Results(
            id = "classMap",
            value = {
                    @Result(id = true, column = "SCI_ID", property = "classId"),
                    @Result(column = "SCI_NAME", property = "className"),
                    @Result(column = "SCI_DESCRIBE", property = "classDescribe")
            }
    )
    @Select("SELECT * FROM SG_CLASS_INF WHERE SCI_ID = #{0}")
    ClassEntity getClassById(int id);

}
