package me.merit.dao.impl;

import me.merit.dao.ComputerLabDao;
import me.merit.entity.ComputerLabEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComputerLabDaoImpl extends GenericDaoImpl<ComputerLabEntity, Integer> implements ComputerLabDao {
    @Autowired
    private SessionFactory sessionFactory;
}
