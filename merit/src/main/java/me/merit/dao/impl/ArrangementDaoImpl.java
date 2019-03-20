package me.merit.dao.impl;

import me.merit.dao.ArrangementDao;
import me.merit.entity.ArrangementEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ArrangementDaoImpl extends GenericDaoImpl<ArrangementEntity, Integer> implements ArrangementDao {
}
