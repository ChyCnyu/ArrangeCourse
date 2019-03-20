package me.merit.service.impl;

import me.merit.dao.ClazzDao;
import me.merit.entity.ClazzEntity;
import me.merit.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzDao clazzDao;

    public ClazzEntity get(String id) {
        try {
            return clazzDao.findById(ClazzEntity.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean add(ClazzEntity clazzEntity) {
        try {
            clazzDao.save(clazzEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(ClazzEntity clazzEntity) {
        try {
            clazzDao.update(clazzEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(String id) {
        try {
            clazzDao.deleteById(ClazzEntity.class, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
