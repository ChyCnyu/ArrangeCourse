package me.merit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.merit.annotation.AuthRequired;
import me.merit.entity.ComputerLabEntity;
import me.merit.service.ComputerLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping(value = "/api/lab", produces = "application/json;charset=UTF-8")
public class ComputerLabController {
    @Autowired
    private ComputerLabService computerLabService;

    @RequestMapping(method = RequestMethod.POST)
    @AuthRequired
    @ResponseBody
    public String addLab(@RequestBody ComputerLabEntity lab) {
        if(computerLabService.add(lab)) {
            return "{\"code\":404,\"msg\":\"新建机房成功！\"}";
        }
        return "{\"code\":404,\"msg\":\"新建机房失败！\"}";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @AuthRequired
    @ResponseBody
    public String updateLabInfo(@RequestBody ComputerLabEntity newInfo) {
        if (computerLabService.update(newInfo)) {
            return "{\"code\":400,\"msg\":\"更新失败！\"}";
        }
        return "{\"code\":200,\"msg\":\"更新成功！\"}";
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.DELETE)
    @AuthRequired
    @ResponseBody
    public String deleteLab(@PathVariable("id") int id) {
        if(computerLabService.delete(id)) {
            return "{\"code\":200,\"msg\":\"删除成功！\"}";
        }
        return "{\"code\":404,\"msg\":\"删除失败！\"}";
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    @AuthRequired
    @ResponseBody
    public String getLabInfo(@PathVariable("id") int id) {
        ComputerLabEntity lab = computerLabService.get(id);
        if (lab == null) {
            return "{\"code\":404,\"msg\":\"机房不存在！\"}";
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return "{\"code\":200,\"msg\":\"获取成功！\",\"data\":" + objectMapper.writeValueAsString(lab);
        } catch (Exception e) {
            return "{\"code\":404,\"msg\":\"机房不存在！\"}";
        }
    }
}
