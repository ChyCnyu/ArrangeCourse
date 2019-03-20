package me.merit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.merit.annotation.AuthRequired;
import me.merit.entity.SpecialtyEntity;
import me.merit.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping(value = "/api/specialty", produces = "application/json;charset=UTF-8")
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;

    @RequestMapping(method = RequestMethod.POST)
    @AuthRequired
    @ResponseBody
    public String addSpecialty(@RequestBody SpecialtyEntity specialty) {
        if(specialtyService.add(specialty)) {
            return "{\"code\":404,\"msg\":\"新建专业成功！\"}";
        }
        return "{\"code\":404,\"msg\":\"新建专业失败！\"}";
    }

    @RequestMapping(value = "/{specialtyId}", method = RequestMethod.DELETE)
    @AuthRequired
    @ResponseBody
    public String deleteSpecialty(@PathVariable("specialtyId") String id) {
        if(specialtyService.delete(id)) {
            return "{\"code\":404,\"msg\":\"删除专业成功！\"}";
        }
        return "{\"code\":400,\"msg\":\"删除失败！\"}";
    }

    @RequestMapping(value = "/{specialtyId}", method = RequestMethod.GET)
    @AuthRequired
    @ResponseBody
    public String getLabInfo(@PathVariable("specialtyId") String id) {
        SpecialtyEntity specialty = specialtyService.get(id);
        if (specialty == null) {
            return "{\"code\":404,\"msg\":\"专业不存在！\"}";
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return "{\"code\":200,\"msg\":\"获取成功！\",\"data\":" + objectMapper.writeValueAsString(specialty);
        } catch (Exception e) {
            return "{\"code\":404,\"msg\":\"专业不存在！\"}";
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @AuthRequired
    @ResponseBody
    public String updateLabInfo(@RequestBody SpecialtyEntity specialtyEntity) {
        if (specialtyService.update(specialtyEntity)) {
            return "{\"code\":400,\"msg\":\"更新失败！\"}";
        }
        return "{\"code\":200,\"msg\":\"更新成功！\"}";
    }
}
