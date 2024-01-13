package com.sg.back.card.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CardDao {
    Logger logger = LoggerFactory.getLogger(CardDao.class);
    @Autowired
    SqlSessionTemplate sqlSessionTemplate=null;
    public List<Map<String, Object>> getCard(Map<String, Object> cmap) {
        logger.info("carddao : getCard");
        List<Map<String,Object>> cardList=null;
        cardList=sqlSessionTemplate.selectList("getCard",cmap);
        return cardList;
    }
    
}
