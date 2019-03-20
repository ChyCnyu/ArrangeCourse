package me.merit.service.impl;

import me.merit.dao.SpecialtyDao;
import me.merit.entity.SpecialtyEntity;
import me.merit.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    @Autowired
    private SpecialtyDao specialtyDao;

    public boolean add(SpecialtyEntity specialtyEntity) {
        try {
            specialtyDao.save(specialtyEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(String id) {
        try {
            specialtyDao.deleteById(SpecialtyEntity.class, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public SpecialtyEntity get(String id) {
        try {
            return specialtyDao.findById(SpecialtyEntity.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean update(SpecialtyEntity specialtyEntity) {
        try {
            specialtyDao.update(specialtyEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
