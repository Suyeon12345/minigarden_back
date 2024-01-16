package com.sg.back.card.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sg.back.card.logic.UsersLogic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users/*")
public class UsersController {
    Logger logger = LoggerFactory.getLogger(UsersController.class);
    
    @Autowired
    UsersLogic usersLogic = null;
    @GetMapping("userslist")
    public String usersList(@RequestParam Map<String,Object> umap) {
        logger.info("usersList");
        logger.info(umap.toString());
        List<Map<String,Object>> usersList = null;
        usersList = usersLogic.getusers(umap);
        Gson g = new Gson();
        String temp = g.toJson(usersList);
        return temp;
    }
    
}
