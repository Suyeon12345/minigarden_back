package com.sg.back.lsg.controller;

import com.google.gson.Gson;
import com.sg.back.lsg.logic.EmpLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp/*")
public class EmpController {
    Logger logger = LoggerFactory.getLogger(EmpController.class);
    @Autowired
    private EmpLogic empLogic = null;

    // 직원 조회
    @GetMapping("empList")
    public String empList(@RequestParam Map<String, Object> eMap) {
        logger.info("empList");
        List<Map<String, Object>> eList = null;
        eList = empLogic.empList(eMap);
        Gson g = new Gson();
        String temp = g.toJson(eList);
        return temp;
    }

    // 직원 상세조회
    @GetMapping("empDetail")
    public String empDetail(@RequestParam Map<String, Object> eMap) {
        logger.info("empDetail");
        List<Map<String, Object>> eList = null;
        eList = empLogic.empDetail(eMap);
        Gson g = new Gson();
        String temp = g.toJson(eList);
        return temp;
    }

    // 직원 수정
    @PutMapping("empUpdate")
    public String empUpdate(@RequestBody Map<String, Object> eMap) {
        logger.info("empUpdate");
        logger.info(eMap.toString());
        int result = 0;
        result = empLogic.empUpdate(eMap);
        return String.valueOf(result);
    }

    // 직원 삭제
    @GetMapping("empDelete")
    public String empDelete(int e_code) {
        logger.info("empDelete");
        int result = 0;
        result = empLogic.empDelete(e_code);
        Gson g = new Gson();
        String temp = g.toJson(result);
        return temp;
    }

    // 조회된 직원 리스트 엑셀로 다운
}
