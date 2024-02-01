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

    public  List<Map<String, Object>> consultList(Map<String, Object> umap) {
        logger.info("consultList-dao");
        List<Map<String,Object>> consultList=sqlSessionTemplate.selectList("consultList",umap);
        logger.info(consultList.toString());
        return consultList;
    }
    public int consultInsert(Map<String, Object> umap) {
        logger.info("consultInsert-dao");
       int result = 0;
       result=sqlSessionTemplate.insert("consultInsert", umap);
       return result;
    }
    public int consultDelete(int tb_num) {
        logger.info("consultDelete-dao");
        int result=0;
        result=sqlSessionTemplate.delete("consultDelete",tb_num);
        return result;
    }
    
}
