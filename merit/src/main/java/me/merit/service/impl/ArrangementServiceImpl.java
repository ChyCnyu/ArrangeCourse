package me.merit.service.impl;

import me.merit.dao.ArrangementDao;
import me.merit.entity.ArrangementEntity;
import me.merit.service.ArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrangementServiceImpl implements ArrangementService {
    @Autowired
    private ArrangementDao arrangementDao;

    public boolean add(ArrangementEntity arrangementEntity) {
        try {
            arrangementDao.save(arrangementEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(ArrangementEntity arrangementEntity) {
        try {
            arrangementDao.update(arrangementEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            arrangementDao.deleteById(ArrangementEntity.class, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrangementEntity get(int id) {
        try {
            return arrangementDao.findById(ArrangementEntity.class, id);
        } catch (Exception e) {
            return null;
        }
    }
}
