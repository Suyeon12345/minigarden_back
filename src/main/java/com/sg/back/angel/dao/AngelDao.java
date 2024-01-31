package com.sg.back.angel.dao;

import com.sg.back.angel.vo.AngelVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Repository
public class AngelDao {
    Logger logger = LoggerFactory.getLogger(AngelDao.class);
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    @GetMapping("test")

    public String test(){
        logger.info("AngelController");
        return null;
    }

    public List<Map<String, Object>> pgList(Map<String, Object> pmap) {
        logger.info("AngelDao-pgList");
        List<Map<String, Object>> pgList = null;
        pgList = sqlSessionTemplate.selectList("pgList", pmap);
        return pgList;
    }

    public int pgInsert(Map<String, Object> pmap) {
        logger.info("AngelDao-pgInsert");
        int result = 0;
        result = sqlSessionTemplate.insert("pgInsert",pmap);
        return result;
    }

    public int pgDelete(int pg_No) {
        logger.info("AngelDao-pgDelete");
        int result = 0;
        result = sqlSessionTemplate.insert("pgDelete",pg_No);
        return result;
    }

    public List<AngelVO> scheduleList() {
        List<AngelVO> calList = null;
        calList = sqlSessionTemplate.selectList("scheduleList");
        return calList;
    }
}
