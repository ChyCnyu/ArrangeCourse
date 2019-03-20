package me.merit.dao;

import java.util.List;

public interface GenericDao<T, PK> {
    void save(T entity);
    void delete(T entity);
    void deleteById(Class<T> entityClass, PK id);
    void saveOrUpdate(T entity);
    void update(T entity);
    List<T> findAll(Class<T> entityClass);
    T findById(Class<T> entityClass, PK id);
    List<T> findByProperty(Class<T> entityClass, String name, Object value);
    List<T> findByHql(Class<T> entityClass, String hql, Object[] params);
    List<T> findByPage(Class<T> entityClass, int start, int limit);
    int getTotalCount(Class<T> entityClass);
}
