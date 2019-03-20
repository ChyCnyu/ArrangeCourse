package me.merit.service;

import me.merit.entity.ClazzEntity;

public interface ClazzService {
    ClazzEntity get(String id);
    boolean add(ClazzEntity clazzEntity);
    boolean update(ClazzEntity clazzEntity);
    boolean delete(String id);
}
