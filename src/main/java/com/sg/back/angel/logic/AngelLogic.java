package com.sg.back.angel.logic;

import com.sg.back.angel.dao.AngelDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Service
public class AngelLogic {
    Logger logger = LoggerFactory.getLogger(AngelLogic.class);
    @Autowired
    AngelDao angelDao;
    @GetMapping("test")

    public String test(){
        logger.info("AngelController");
        return null;
    }

    public List<Map<String, Object>> pgList(Map<String, Object> pmap) {
        logger.info("AngelLogic-pgList");
        List<Map<String, Object>> pgList = null;
        pgList = angelDao.pgList(pmap);
        return pgList;
    }

    public int pgInsert(Map<String, Object> pmap) {
        logger.info("AngelLogic-pgInsert");
        int result = 0;
        result = angelDao.pgInsert(pmap);
        return result;
    }
}
