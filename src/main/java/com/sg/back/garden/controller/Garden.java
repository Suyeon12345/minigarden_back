package com.sg.back.garden.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/garden/*")
public class Garden {
    Logger logger = LoggerFactory.getLogger(Garden.class);
    @GetMapping("test")
    public String test(@RequestParam Map<String, Object> rmap){
        logger.info("test호출");
        logger.info(rmap.toString());
        return "ok";
    }
}
