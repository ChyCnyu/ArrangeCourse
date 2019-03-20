package me.merit.service.impl;

import me.merit.dao.ExperimentDao;
import me.merit.entity.ExperimentEntity;
import me.merit.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperimentServiceImpl implements ExperimentService {
    @Autowired
    private ExperimentDao experimentDao;

    public boolean add(ExperimentEntity experimentEntity) {
        try {
            experimentDao.save(experimentEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(ExperimentEntity experimentEntity) {
        try {
            experimentDao.update(experimentEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(String id) {
        try {
            experimentDao.deleteById(ExperimentEntity.class, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ExperimentEntity get(String id) {
        try {
            return experimentDao.findById(ExperimentEntity.class, id);
        } catch (Exception e) {
            return null;
        }
    }
}
