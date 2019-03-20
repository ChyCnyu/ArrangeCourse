package me.merit.dao;

import me.merit.entity.UserEntity;

public interface UserDao extends GenericDao<UserEntity, String> {
    boolean updateByHql(String hql, Object[] params);
}
