package me.merit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.merit.annotation.AuthRequired;
import me.merit.entity.UserEntity;
import me.merit.pojo.Form.AddUserForm;
import me.merit.pojo.Form.LoginForm;
import me.merit.pojo.Form.UpdateUserForm;
import me.merit.pojo.Form.QueryUserForm;
import me.merit.pojo.ResponsePojo;
import me.merit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/api/user", produces = "application/json;charset=UTF-8")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping(method = RequestMethod.POST)
    @AuthRequired
    @ResponseBody
    public String addUser(@RequestBody AddUserForm userToAdd) {
        if(userService.add(userToAdd)){
            return "{\"code\":200,\"msg\":\"add user success\"}";
        }
        return "{\"code\":400,\"msg\":\"request not validated\"}";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @AuthRequired
    @ResponseBody
    public String updateUserInfo(@RequestBody UpdateUserForm user) {
        userService.updateInfo(user);
        return "{\"code\":200,\"msg\":\"更新成功\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @AuthRequired
    @ResponseBody
    public ResponsePojo delUser(@PathVariable("id") String id) {
        if(userService.delete(id)) {
            return new ResponsePojo(200, "删除用户成功！");
        }
        return new ResponsePojo(400, "删除用户失败！");
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @AuthRequired
    @ResponseBody
    public String getUserInfo(@PathVariable("id") String number) {
        QueryUserForm uip = userService.getInfo(number);
        if(uip == null) {
            return "{\"code\":404,\"msg\":\"用户不存在！\"}";
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(uip);
        } catch (Exception e) {
            return "{\"code\":500,\"msg\":\"未知错误！\"}";
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @AuthRequired
    @ResponseBody
    public ResponsePojo getUsersList(@RequestParam("page") int page, @RequestParam("pageNum") int pageNum) {
        int count = userService.count();
        int start;
        if(count < 1) {
            return new ResponsePojo(404, "用户列表为空");
        } else {
            start = (page - 1) * pageNum;
        }
        List<UserEntity> users = userService.getUsers(start, pageNum);
        return new ResponsePojo(200, "获取用户列表成功！", users);
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    @ResponseBody
    public String getToken(@RequestBody LoginForm loginPojo) {
        String token = userService.login(loginPojo.getId(), loginPojo.getPassword());
        if(token == null) {
            return "{\"code\":401,\"msg\":\"认证失败！\"}";
        }
        else {
            return "{\"code\":200,\"msg\":\"认证成功！\",\"data\":{\"token\":\"" + token + "\"}}";
        }
    }

    @RequestMapping(value = "/self", method = RequestMethod.GET)
    @AuthRequired
    @ResponseBody
    public ResponsePojo getSelfInfo() {
        String id = httpSession.getAttribute("user_id").toString();
        QueryUserForm quf = userService.getInfo(id);
        if(quf != null) {
            ResponsePojo data = new ResponsePojo(200, "获取成功！", quf);
            return data;
        }
        return new ResponsePojo(400, "获取失败！");
    }
}
