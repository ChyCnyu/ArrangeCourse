package me.merit.entity;

import javax.persistence.*;

@Entity
@Table(name = "class", schema = "merit", catalog = "")
public class ClazzEntity {
    private String id;
    private int studentCount;
    private String courseId;
    private String specialtyId;
    private int teacherId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student_count")
    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
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
    @Column(name = "specialty_id")
    public String getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Basic
    @Column(name = "teacher_id")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClazzEntity that = (ClazzEntity) o;

        if (studentCount != that.studentCount) return false;
        if (teacherId != that.teacherId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (specialtyId != null ? !specialtyId.equals(that.specialtyId) : that.specialtyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + studentCount;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (specialtyId != null ? specialtyId.hashCode() : 0);
        result = 31 * result + teacherId;
        return result;
    }
}
