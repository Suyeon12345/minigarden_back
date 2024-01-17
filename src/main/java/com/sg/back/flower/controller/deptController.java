package com.sg.back.flower.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sg.back.flower.logic.deptLogic;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/flower/*")
@Log4j2
public class deptController {

    @Autowired
    deptLogic deptLogic = null;

    @GetMapping("deptlist")
    public String deptList(Map<String, Object> pamp){
        log.info("deptlist-deptcontroller 호출");
        List<Map<String, Object>> list = null;
        list = deptLogic.deptList(pamp);
        Gson g = new Gson();
        String temp = g.toJson(list);

        return temp;
    }

    @PostMapping("deptcreate")
    public void deptCreate(@RequestParam Map<String, Object> pmap){
        log.info("deptcreate-deptcontroller 호출");
        deptLogic.deptCreate(pmap);
    }
    
}
