package me.merit.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "arrangement", schema = "merit", catalog = "")
public class ArrangementEntity {
    private int id;
    private String labId;
    private String classId;
    private String courseId;
    private Integer studentsNumber;
    private Timestamp itval;
    private int week;
    private int weekDay;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lab_id")
    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    @Basic
    @Column(name = "class_id")
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "course_id")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "students_number")
    public Integer getStudentsNumber() {
        return studentsNumber;
    }

    public void setStudentsNumber(Integer studentsNumber) {
        this.studentsNumber = studentsNumber;
    }

    @Basic
    @Column(name = "itval")
    public Timestamp getItval() {
        return itval;
    }

    public void setItval(Timestamp itval) {
        this.itval = itval;
    }

    @Basic
    @Column(name = "week")
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Basic
    @Column(name = "week_day")
    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrangementEntity that = (ArrangementEntity) o;

        if (id != that.id) return false;
        if (week != that.week) return false;
        if (weekDay != that.weekDay) return false;
        if (labId != null ? !labId.equals(that.labId) : that.labId != null) return false;
        if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (studentsNumber != null ? !studentsNumber.equals(that.studentsNumber) : that.studentsNumber != null)
            return false;
        if (itval != null ? !itval.equals(that.itval) : that.itval != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (labId != null ? labId.hashCode() : 0);
        result = 31 * result + (classId != null ? classId.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (studentsNumber != null ? studentsNumber.hashCode() : 0);
        result = 31 * result + (itval != null ? itval.hashCode() : 0);
        result = 31 * result + week;
        result = 31 * result + weekDay;
        return result;
    }
}
