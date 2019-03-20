package me.merit.dao.impl;

import me.merit.dao.GenericDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void deleteById(Class<T> entityClass, PK id) {
        sessionFactory.getCurrentSession().delete(findById(entityClass, id));
    }

    public void saveOrUpdate(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    public void update(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public List<T> findAll(Class<T> entityClass) {
        String hql = "FROM  " + entityClass.getName();
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    public T findById(Class<T> entityClass, PK id) {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }

    public List<T> findByProperty(Class<T> entityClass, String name, Object value) {
        String hql = "FROM " + entityClass.getName() + " WHERE ? = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, name);
        query.setParameter(1, value);
        return query.list();
    }

    public List<T> findByHql(Class<T> entityClass, String hql, Object[] params) {
        if(params == null || params.length < 1)
            return null;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        for(int i=0;i<params.length;++i) {
            query.setParameter(i, params[i]);
        }
        return query.list();
    }

    public List<T> findByPage(Class<T> entityClass, int start, int limit) {
        String hql = "SELECT model from " + entityClass.getName() + " model";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setFirstResult(start).setMaxResults(limit);
        return query.list();
    }

    public int getTotalCount(Class entityClass) {
        String hql = "SELECT COUNT(model) FROM " + entityClass.getName() + " model";
        return (Integer) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
    }
}
