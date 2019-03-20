package me.merit.service;

import me.merit.entity.ComputerLabEntity;

public interface ComputerLabService {
    boolean add(ComputerLabEntity computerLabEntity);
    boolean delete(int id);
    ComputerLabEntity get(int id);
    boolean update(ComputerLabEntity lab);
}
