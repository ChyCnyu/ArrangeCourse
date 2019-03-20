package me.merit.service.impl;

import me.merit.dao.ComputerLabDao;
import me.merit.entity.ComputerLabEntity;
import me.merit.service.ComputerLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("computerLabService")
public class ComputerLabServiceImpl implements ComputerLabService {
    @Autowired
    private ComputerLabDao computerLabDao;

    public boolean add(ComputerLabEntity computerLabEntity) {
        try {
            computerLabDao.save(computerLabEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            computerLabDao.deleteById(ComputerLabEntity.class, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ComputerLabEntity get(int id) {
        try {
            return computerLabDao.findById(ComputerLabEntity.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean update(ComputerLabEntity newInfo) {
        try {
            computerLabDao.update(newInfo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
