package me.merit.service;

import me.merit.entity.ExperimentEntity;

public interface ExperimentService {
    boolean add(ExperimentEntity experimentEntity);
    boolean update(ExperimentEntity experimentEntity);
    boolean delete(String id);
    ExperimentEntity get(String id);
}
