package me.merit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.merit.annotation.AuthRequired;
import me.merit.entity.ExperimentEntity;
import me.merit.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping(value = "/api/experiment", produces = "application/json;charset=UTF-8")
public class ExperimentController {
    @Autowired
    private ExperimentService experimentService;

    @RequestMapping(method = RequestMethod.POST)
    @AuthRequired
    @ResponseBody
    public String addExperiment(@RequestBody ExperimentEntity experimentEntity) {
        if (experimentService.add(experimentEntity)) {
            return "{\"code\":200,\"msg\":\"新建实验成功！\"}";
        }
        return "{\"code\":400,\"msg\":\"新建实验失败！\"}";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @AuthRequired
    @ResponseBody
    public String updateExperiment(@RequestBody ExperimentEntity experimentEntity) {
        if (experimentService.update(experimentEntity)) {
            return "{\"code\":200,\"msg\":\"更新实验成功！\"}";
        }
        return "{\"code\":400,\"msg\":\"更新实验失败！\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @AuthRequired
    @ResponseBody
    public String updateExperiment(@PathVariable("id") String id) {
        ExperimentEntity experiment = experimentService.get(id);
        if(experiment == null) {
            return "{\"code\":404,\"msg\":\"实验不存在！\"}";
        }
        try {
            String data = new ObjectMapper().writeValueAsString(experiment);
            return "{\"code\":200,\"msg\":\"获取实验成功！\",\"data\":" + data + "}";
        } catch (Exception e) {
            return "{\"code\":404,\"msg\":\"实验不存在！\"}";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @AuthRequired
    @ResponseBody
    public String delExperiment(@PathVariable("id") String id) {
        if (experimentService.delete(id)) {
            return "{\"code\":200,\"msg\":\"删除实验成功！\"}";
        }
        return "{\"code\":400,\"msg\":\"删除实验失败！\"}";
    }
}
