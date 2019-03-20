package me.merit.service.impl;

import me.merit.dao.CourseDao;
import me.merit.entity.CourseEntity;
import me.merit.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    public boolean add(CourseEntity courseEntity) {
        try {
            courseDao.save(courseEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(CourseEntity courseEntity) {
        try {
            courseDao.update(courseEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(String id) {
        try {
            courseDao.deleteById(CourseEntity.class, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public CourseEntity get(String id) {
        try {
            return courseDao.findById(CourseEntity.class, id);
        } catch (Exception e) {
            return null;
        }
    }
}
