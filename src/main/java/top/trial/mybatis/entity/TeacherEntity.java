package top.trial.mybatis.entity;

import java.util.Date;
import java.util.List;

/**
 * Teacher JavaBean
 * <p>
 * 演示mybatis多表查询操作
 *
 * @Author gaoyx1469
 * @Date 2020/7/12
 * @Version 1.0
 */
public class TeacherEntity {
    private int teacherId;
    private String teacherName;
    private Date startTeachingDate;
    private List<ClassEntity> teachClasses;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getStartTeachingDate() {
        return startTeachingDate;
    }

    public void setStartTeachingDate(Date startTeachingDate) {
        this.startTeachingDate = startTeachingDate;
    }

    public List<ClassEntity> getTeachClasses() {
        return teachClasses;
    }

    public void setTeachClasses(List<ClassEntity> teachClasses) {
        this.teachClasses = teachClasses;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", startTeachingDate=" + startTeachingDate +
                ", teachClasses=" + teachClasses +
                '}';
    }
}
