package top.trial.mybatis.entity;

import java.util.List;

/**
 * ClassEntity JavaBean
 * <p>
 * 演示mybatis多表查询操作
 *
 * @Author gaoyx1469
 * @Date 2020/7/12
 * @Version 1.0
 */
public class ClassEntity {
    private int classId;
    private String className;
    private String classDescribe;
    private List<StudentEntity> classStudents;
    private List<TeacherEntity> classTeachers;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDescribe() {
        return classDescribe;
    }

    public void setClassDescribe(String classDescribe) {
        this.classDescribe = classDescribe;
    }

    public List<StudentEntity> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(List<StudentEntity> classStudents) {
        this.classStudents = classStudents;
    }

    public List<TeacherEntity> getClassTeacher() {
        return classTeachers;
    }

    public void setClassTeacher(List<TeacherEntity> classTeachers) {
        this.classTeachers = classTeachers;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classDescribe='" + classDescribe + '\'' +
                ", classStudents=" + classStudents +
                ", classTeachers=" + classTeachers +
                '}';
    }
}
