package me.merit.dao.impl;

import me.merit.dao.RoleDao;
import me.merit.entity.RoleEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<RoleEntity, Integer> implements RoleDao {
    public RoleEntity get(int id) {
        return findById(RoleEntity.class, id);
    }
}
