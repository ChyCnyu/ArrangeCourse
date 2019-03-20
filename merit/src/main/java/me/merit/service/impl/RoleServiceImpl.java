package me.merit.service.impl;

import me.merit.dao.RoleDao;
import me.merit.entity.RoleEntity;
import me.merit.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    public RoleEntity get(int id) {
        return roleDao.get(id);
    }
}
