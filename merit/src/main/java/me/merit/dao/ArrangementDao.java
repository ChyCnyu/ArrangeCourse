package me.merit.dao;

import me.merit.entity.ArrangementEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrangementDao extends GenericDao<ArrangementEntity, Integer> {
}
