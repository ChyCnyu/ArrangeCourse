package me.merit.service;

import me.merit.entity.ArrangementEntity;

import java.util.List;

public interface ArrangementService {
    boolean add(ArrangementEntity arrangementEntity);
    boolean update(ArrangementEntity arrangementEntity);
    boolean delete(int id);
    ArrangementEntity get(int id);
}
