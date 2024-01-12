package com.sg.back.garden.controller;

import com.google.gson.Gson;
import com.sg.back.garden.logic.GardenLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/garden/*")
public class Garden {
    Logger logger = LoggerFactory.getLogger(Garden.class);

    @Autowired
    GardenLogic gardenLogic = null;
    @GetMapping("test")
    public String test(@RequestParam Map<String, Object> rmap){
        logger.info("test호출");
        logger.info(rmap.toString());
        List<Map<String, Object>> gList = null;
        gList = gardenLogic.getOK(rmap);
        Gson g = new Gson();
        String temp = g.toJson(gList);
        return temp;
    }
}
