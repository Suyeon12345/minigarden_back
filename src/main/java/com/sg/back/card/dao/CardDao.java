package com.sg.back.card.dao;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.sg.back.card.logic.CardLogic;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

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
    public List<Map<String, Object>> getusers(Map<String, Object> umap) {
        logger.info("carddao : getUsers-dao");
        List<Map<String,Object>> usersList=null;
        usersList=sqlSessionTemplate.selectList("usersList",umap);
        return usersList;
    }
    public int makeCard(Map<String, Object> cMap) {
       logger.info("makeCard-dao");
       int result = 0;
       result = sqlSessionTemplate.insert("makeCard",cMap);
       return result;
    }
    
}
