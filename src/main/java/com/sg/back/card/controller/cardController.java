package com.sg.back.card.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sg.back.card.logic.CardLogic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/card/*")
public class CardController {
    Logger logger = LoggerFactory.getLogger(CardController.class);
    
    @Autowired
    CardLogic cardLogic = null;
    @GetMapping("cardpicker")
    public String CardPicker(@RequestParam Map<String,Object> cmap) {
        logger.info("cardPicker");
        logger.info(cmap.toString());
        List<Map<String,Object>> cardList = null;
        cardList = cardLogic.getCard(cmap);
        Gson g = new Gson();
        String temp = g.toJson(cardList);
        return temp;
    }
    @GetMapping("userslist")
    public String usersList(@RequestParam Map<String,Object> umap) {
        logger.info("usersList");
        logger.info(umap.toString());
        List<Map<String,Object>> usersList = null;
        usersList = cardLogic.getusers(umap);
        Gson g = new Gson();
        String temp = g.toJson(usersList);
        return temp;
    }
    @GetMapping("userdetail")
    public String userDetail(@RequestParam Map<String,Object> umap) {
        logger.info("userDetail");
        logger.info(umap.toString());
        List<Map<String,Object>> userdetail = null;
        userdetail = cardLogic.getusers(umap);
        Gson g = new Gson();
        String temp = g.toJson(userdetail);
        return temp;
    }

     @PostMapping("makecard")
    public String makeCard(@RequestBody Map<String,Object> cMap) {
        logger.info("makeCard");
        logger.info(cMap.toString());
        int result =0;
        result= cardLogic.makeCard(cMap);
        
        return String.valueOf(result);
    }
}
