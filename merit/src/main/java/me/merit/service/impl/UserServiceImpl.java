package me.merit.service.impl;

import me.merit.dao.RoleDao;
import me.merit.dao.UserDao;
import me.merit.entity.RoleEntity;
import me.merit.pojo.Form.AddUserForm;
import me.merit.pojo.Form.UpdateUserForm;
import me.merit.pojo.Form.QueryUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import me.merit.entity.UserEntity;
import me.merit.service.UserService;

import java.util.List;

import static me.merit.util.TokenUtil.Md5;
import static me.merit.util.TokenUtil.generateToken;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Value("${apiKey}")
    private String apiKey;

    @Value("${tokenExpiration}")
    private String tokenExpiration;

    public String login(String id, String password) {
        Object[] params = new Object[2];
        params[0] = id;
        params[1] = password;
        String hql = "SELECT m FROM UserEntity m WHERE id = ? AND passhash = MD5(?)";
        List<UserEntity> users = userDao.findByHql(UserEntity.class, hql, params);
        if (users.size() == 0) {
            return null;
        }
        return generateToken(users.get(0));
    }

    public boolean add(AddUserForm user) {
        String name = user.getName(),
                number = user.getId(),
                password = user.getPassword();
        if (name == null || number == null || password == null) {
            return false;
        }
        if (name.length() < 1 || name.length() > 20 || number.length() > 12
                || number.length() < 1 || password.length() < 6 || password.length() > 20) {
            return false;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setId(number);
        userEntity.setPasshash(Md5(password));
        userEntity.setActive(user.isActive());

        RoleEntity role = roleDao.get(user.getRoleId());
        if(role == null) {
            role = roleDao.get(1);
        }
        userEntity.setRoleByRoleId(role);
        userDao.save(userEntity);
        return true;
    }

    public QueryUserForm getInfo(String id) {
        UserEntity user = userDao.findById(UserEntity.class, id);
        if(user == null)
            return null;
        QueryUserForm uip = new QueryUserForm(user.getName(),
                user.getId(), user.getEmail(), user.getPhone(),
                user.getActive().toString().equals("1"),
                user.getRoleByRoleId().getName());
        return uip;
    }

    public void updateInfo(UpdateUserForm userInfo) {
        String hql = "UPDATE UserEntity SET name = ?, email = ?, phone = ? WHERE id = ?";
        Object params[] = new Object[4];
        params[0] = userInfo.getName();
        params[1] = userInfo.getEmail();
        params[2] = userInfo.getPhone();
        params[3] = userInfo.getId();
        userDao.updateByHql(hql, params);
    }

    public boolean delete(String id) {
        try {
            userDao.deleteById(UserEntity.class, id);
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public int count() {
        return userDao.getTotalCount(UserEntity.class);
    }

    public List<UserEntity> getUsers(int start, int limit) {
        try {
            return userDao.findByPage(UserEntity.class, start, limit);
        } catch (Exception e) {
            return null;
        }
    }
}
