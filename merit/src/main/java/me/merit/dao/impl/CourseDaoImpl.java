package me.merit.dao.impl;

import me.merit.dao.CourseDao;
import me.merit.entity.CourseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl extends GenericDaoImpl<CourseEntity, String> implements CourseDao {
}
