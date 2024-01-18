package com.sg.back.angel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/angel/*")
public class AngelController {
    Logger logger = LoggerFactory.getLogger(AngelController.class);
    @GetMapping("test")

    public String test(){
        logger.info("AngelController");
        return null;
    }
}
