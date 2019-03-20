package me.merit.service;

import me.merit.entity.CourseEntity;

public interface CourseService {
    boolean add(CourseEntity courseEntity);
    boolean update(CourseEntity courseEntity);
    boolean delete(String id);
    CourseEntity get(String id);
}
