package com.sg.back.angel.controller;

import com.google.gson.Gson;
import com.sg.back.angel.logic.AngelLogic;
import com.sg.back.angel.vo.AngelVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/angel/*")
public class AngelController {
    Logger logger = LoggerFactory.getLogger(AngelController.class);
    @Autowired
    AngelLogic angelLogic;

//    전체 목록조회하기
    @GetMapping("pgList")
    public String pgList(@RequestParam Map<String, Object> pmap){
        logger.info("AngelController-pgList");
        List<Map<String, Object>> pgList = null;
        pgList = angelLogic.pgList(pmap);
        if(pgList.size() == 0){
            logger.info("조회된 데이터가 없습니다.");
            return "noData";
        }
        logger.info(pgList.toString());
        Gson g = new Gson();
        String temp = g.toJson(pgList);
        return temp;
//        return "success";
    }
//  프로그램 상세 조회하기
    @GetMapping("pgDetail")
    public String pgDetail(@RequestParam Map<String, Object> pmap){
        logger.info("AngelController-pgDetail");
        List<Map<String, Object>> pgList = null;
        pgList = angelLogic.pgList(pmap);
        Gson g = new Gson();
        String temp = g.toJson(pgList);
        System.out.println(temp);
        return temp;
    }

//    프로그램 등록하기
    @PostMapping("pgInsert")
    public String pgInsert(@RequestBody Map<String, Object> pmap){
        logger.info("AngelController-pgInsert");
        int result = 0;
        result = angelLogic.pgInsert(pmap);
        return String.valueOf(result);
    }
    @DeleteMapping("pgDelete")
    public String pgDelete(int pg_no){
        logger.info("AngelController-pgDelete");
        int result = 0;
        result = angelLogic.pgDelete(pg_no);
        return String.valueOf(result);
    }
    @GetMapping("scheduleList")
    public String scheduleList(){
        logger.info("scheduleList");
        List<AngelVO> calList = null;
        calList = angelLogic.scheduleList();
        logger.info(calList.toString());
        Gson g = new Gson();
        String temp = g.toJson(calList);
        return temp;
    }
}
