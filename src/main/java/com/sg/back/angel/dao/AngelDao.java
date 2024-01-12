package com.sg.back.garden.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GardenDao {
    Logger logger = LoggerFactory.getLogger(GardenDao.class);
    @Autowired
    SqlSessionTemplate sqlSessionTemplate = null;

    public List<Map<String, Object>> getOK(Map<String, Object> rmap) {
        logger.info("Garden Dao: getOK");
        List<Map<String, Object>> gList = null;
        gList = sqlSessionTemplate.selectList("getOK",rmap);
        return gList;
    }
}
