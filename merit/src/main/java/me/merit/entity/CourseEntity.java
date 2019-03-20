package me.merit.entity;

import javax.persistence.*;

@Entity
@Table(name = "course", schema = "merit", catalog = "")
public class CourseEntity {
    private String id;
    private String name;
    private int totalTime;
    private int experimentTime;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "total_time")
    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    @Basic
    @Column(name = "experiment_time")
    public int getExperimentTime() {
        return experimentTime;
    }

    public void setExperimentTime(int experimentTime) {
        this.experimentTime = experimentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (totalTime != that.totalTime) return false;
        if (experimentTime != that.experimentTime) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + totalTime;
        result = 31 * result + experimentTime;
        return result;
    }
}
