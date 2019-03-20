package me.merit.dao.impl;

import me.merit.dao.ExperimentDao;
import me.merit.entity.ExperimentEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ExperimentDaoImpl extends GenericDaoImpl<ExperimentEntity, String> implements ExperimentDao {
}
