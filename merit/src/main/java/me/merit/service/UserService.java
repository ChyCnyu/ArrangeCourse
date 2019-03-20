package me.merit.service;

import me.merit.entity.UserEntity;
import me.merit.pojo.Form.AddUserForm;
import me.merit.pojo.Form.UpdateUserForm;
import me.merit.pojo.Form.QueryUserForm;

import java.util.List;

public interface UserService {
    // 返回token
    String login(String id, String password);

    boolean add(AddUserForm user);

    QueryUserForm getInfo(String id);

    void updateInfo(UpdateUserForm userInfo);

    boolean delete(String id);

    int count();

    List<UserEntity> getUsers(int start, int limit);
}
