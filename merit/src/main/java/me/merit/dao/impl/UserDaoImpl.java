package me.merit.dao.impl;

import me.merit.dao.UserDao;
import me.merit.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserEntity, String> implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public boolean updateByHql(String hql, Object[] params) {
        if(params == null || params.length < 1)
            return false;
        try {
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            for (int i = 0; i < params.length; ++i) {
                query.setParameter(i, params[i]);
            }
            return query.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
