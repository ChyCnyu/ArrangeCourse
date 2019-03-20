package me.merit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.merit.annotation.AuthRequired;
import me.merit.entity.ArrangementEntity;
import me.merit.pojo.ResponsePojo;
import me.merit.service.ArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping(value = "/api/arrangement", produces = "application/json;charset=UTF-8")
public class ArrangementController {
    @Autowired
    private ArrangementService arrangementService;

    @RequestMapping(method = RequestMethod.POST)
    @AuthRequired
    @ResponseBody
    public ResponsePojo addExperiment(@RequestBody ArrangementEntity arrangementEntity) {
        if (arrangementService.add(arrangementEntity)) {
            return new ResponsePojo(200, "新建排课条目成功！");
        }
        return new ResponsePojo(400, "新建排课条目失败！");
    }

    @RequestMapping(method = RequestMethod.PUT)
    @AuthRequired
    @ResponseBody
    public ResponsePojo updateExperiment(@RequestBody ArrangementEntity arrangementEntity) {
        if (arrangementService.update(arrangementEntity)) {
            return new ResponsePojo(200, "更新排课条目成功！");
        }
        return new ResponsePojo(400, "更新排课条目失败！");
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    @AuthRequired
    @ResponseBody
    public ResponsePojo updateArrangement(@PathVariable("id") int id) {
        ArrangementEntity arrangement = arrangementService.get(id);
        if(arrangement == null) {
            return new ResponsePojo(404, "排课条目不存在！");
        }
        try {
            String data = new ObjectMapper().writeValueAsString(arrangement);
            return new ResponsePojo(200, "获取排课条目成功！", data);
        } catch (Exception e) {
            return new ResponsePojo(404, "排课条目不存在！");
        }
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.DELETE)
    @AuthRequired
    @ResponseBody
    public ResponsePojo delArrangement(@PathVariable("id") int id) {
        if (arrangementService.delete(id)) {
            return new ResponsePojo(200, "删除排课条目成功！");
        }
        return new ResponsePojo(400, "删除排课条目失败！");
    }
}
