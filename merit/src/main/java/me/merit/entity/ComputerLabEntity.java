package me.merit.entity;

import javax.persistence.*;

@Entity
@Table(name = "computer_lab", schema = "merit", catalog = "")
public class ComputerLabEntity {
    private String name;
    private String deviceType;
    private int deviceCount;
    private int capacity;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "device_type")
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Basic
    @Column(name = "device_count")
    public int getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(int deviceCount) {
        this.deviceCount = deviceCount;
    }

    @Basic
    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComputerLabEntity labEntity = (ComputerLabEntity) o;

        if (deviceCount != labEntity.deviceCount) return false;
        if (capacity != labEntity.capacity) return false;
        if (name != null ? !name.equals(labEntity.name) : labEntity.name != null) return false;
        if (deviceType != null ? !deviceType.equals(labEntity.deviceType) : labEntity.deviceType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (deviceType != null ? deviceType.hashCode() : 0);
        result = 31 * result + deviceCount;
        result = 31 * result + capacity;
        return result;
    }
}
