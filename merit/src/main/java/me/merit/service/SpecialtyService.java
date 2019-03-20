package me.merit.service;

import me.merit.entity.SpecialtyEntity;

public interface SpecialtyService {
    boolean add(SpecialtyEntity specialtyEntity);
    boolean delete(String id);
    SpecialtyEntity get(String id);
    boolean update(SpecialtyEntity specialtyEntity);
}
