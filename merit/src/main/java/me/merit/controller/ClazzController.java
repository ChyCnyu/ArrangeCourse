package me.merit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.merit.annotation.AuthRequired;
import me.merit.entity.ClazzEntity;
import me.merit.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping(value = "/api/clazz", produces = "application/json;charset=UTF-8")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @RequestMapping(method = RequestMethod.POST)
    @AuthRequired
    @ResponseBody
    public String addCourse(@RequestBody ClazzEntity clazzEntity) {
        if (clazzService.add(clazzEntity)) {
            return "{\"code\":200,\"msg\":\"新建班级成功！\"}";
        }
        return "{\"code\":404,\"msg\":\"新建班级失败！\"}";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @AuthRequired
    @ResponseBody
    public String updateClazz(@RequestBody ClazzEntity clazzEntity) {
        if (clazzService.update(clazzEntity)) {
            return "{\"code\":200,\"msg\":\"更新班级成功！\"}";
        }
        return "{\"code\":400,\"msg\":\"更新班级失败！\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @AuthRequired
    @ResponseBody
    public String delCourse(@PathVariable("id") String id) {
        if (clazzService.delete(id)) {
            return "{\"code\":200,\"msg\":\"删除班级成功！\"}";
        }
        return "{\"code\":400,\"msg\":\"删除班级失败！\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @AuthRequired
    @ResponseBody
    public String getCourse(@PathVariable("id") String id) {
        ClazzEntity clazzEntity = clazzService.get(id);
        if (clazzEntity == null) {
            return "{\"code\":400,\"msg\":\"班级不存在！\"}";
        }
        try {
            String data = new ObjectMapper().writeValueAsString(clazzEntity);
            return "{\"code\":200,\"msg\":\"获取班级成功！\",\"data\":" + data + "}";
        } catch (Exception e) {
            return "{\"code\":400,\"msg\":\"班级不存在！\"}";
        }
    }
}
