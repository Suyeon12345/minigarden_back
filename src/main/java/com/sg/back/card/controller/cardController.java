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
     @PostMapping("makecard")
    public String makeCard(@RequestBody Map<String,Object> cMap) {
        logger.info("makeCard");
        logger.info(cMap.toString());
        int result =0;
        result= cardLogic.makeCard(cMap);
        
        return String.valueOf(result);
    }
}
