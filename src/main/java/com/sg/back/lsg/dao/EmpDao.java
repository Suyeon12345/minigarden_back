package com.sg.back.lsg.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmpDao {
    Logger logger = LoggerFactory.getLogger(EmpDao.class);
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    public List<Map<String, Object>> empList(Map<String, Object> eMap) {
        logger.info("empList");
        List<Map<String, Object>> nList = sqlSessionTemplate.selectList("empList", eMap);
        logger.info(nList.toString());
        return nList;
    }

    public int empUpdate(Map<String, Object> eMap) {
        logger.info("empUpdate");
        int result = 0;
        try {
            result = sqlSessionTemplate.update("empUpdate", eMap);
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return result;
    }

    public int empDelete(int e_code) {
        logger.info("empDelete");
        int result = 0;
        try {
            result = sqlSessionTemplate.delete("empDelete", e_code);
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return result;
    }
}
