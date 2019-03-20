package me.merit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.merit.annotation.AuthRequired;
import me.merit.entity.CourseEntity;
import me.merit.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping(value = "/api/course", produces = "application/json;charset=UTF-8")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.POST)
    @AuthRequired
    @ResponseBody
    public String addCourse(@RequestBody CourseEntity courseEntity) {
        if (courseService.add(courseEntity)) {
            return "{\"code\":200,\"msg\":\"新建课程成功！\"}";
        }
        return "{\"code\":404,\"msg\":\"新建课程失败！\"}";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @AuthRequired
    @ResponseBody
    public String updateCourse(@RequestBody CourseEntity courseEntity) {
        if (courseService.update(courseEntity)) {
            return "{\"code\":200,\"msg\":\"更新课程成功！\"}";
        }
        return "{\"code\":400,\"msg\":\"更新课程失败！\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @AuthRequired
    @ResponseBody
    public String delCourse(@PathVariable("id") String id) {
        if (courseService.delete(id)) {
            return "{\"code\":200,\"msg\":\"删除课程成功！\"}";
        }
        return "{\"code\":400,\"msg\":\"删除课程失败！\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @AuthRequired
    @ResponseBody
    public String getCourse(@PathVariable("id") String id) {
        CourseEntity courseEntity = courseService.get(id);
        if (courseEntity == null) {
            return "{\"code\":400,\"msg\":\"课程不存在！\"}";
        }
        try {
            String data = new ObjectMapper().writeValueAsString(courseEntity);
            return "{\"code\":200,\"msg\":\"获取课程成功！\",\"data\":" + data + "}";
        } catch (Exception e) {
            return "{\"code\":400,\"msg\":\"课程不存在！\"}";
        }
    }
}
