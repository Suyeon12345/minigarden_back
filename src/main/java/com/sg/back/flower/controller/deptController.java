package com.sg.back.flower.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.sg.back.flower.logic.deptLogic;

import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/flower/*")
@CrossOrigin(origins = "http://localhost:3000/")
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

    @GetMapping("deptdetail")
    public String deptDetail(@RequestParam Map<String, Object> pamp){
        log.info("deptdetail-deptcontroller 호출");
        List<Map<String, Object>> list = null;
        list = deptLogic.deptDetail(pamp);
        Gson g = new Gson();
        String temp = g.toJson(list);

        return temp;
    }


    @PostMapping("deptinsert")
    public void deptInsert(@RequestParam Map<String, Object> pmap){
        log.info("deptInsert-deptcontroller 호출");
        deptLogic.deptInsert(pmap);
    }
    

    @PutMapping("deptupdate")
    public void deptUpdate(@RequestParam Map<String, Object> pmap){
        log.info("deptUpdate-deptcontroller 호출");
        deptLogic.deptUpdate(pmap);
    }

    @DeleteMapping("deptdelete")
    public void deptDelete(@RequestParam Map<String, Object> pmap){
        log.info("deptDelete-deptcontroller 호출");
        deptLogic.deptDelete(pmap);
        log.info(pmap);
    }
}
