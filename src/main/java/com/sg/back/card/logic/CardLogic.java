package com.sg.back.card.logic;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.back.card.dao.CardDao;


@Service
public class CardLogic {
    Logger logger = LoggerFactory.getLogger(CardLogic.class);

    @Autowired
    CardDao cardDao = null;

    public List<Map<String, Object>> getCard(Map<String, Object> cmap) {
        logger.info("cardLogic: getCard");
        List<Map<String,Object>>cardList=null;
        cardList=cardDao.getCard(cmap);
        return cardList;
    }

    
    public int makeCard(Map<String, Object> cMap) {
        logger.info("makeCard-Logic");
        int result=0;
        result = cardDao.makeCard(cMap);
        return result;
    }    
    public List<Map<String, Object>> getusers(Map<String, Object> umap) {
        logger.info("cardLogic: getUser");
        List<Map<String,Object>>usersList=null;
        usersList=cardDao.getusers(umap);
        return usersList;
    }


    public List<Map<String, Object>> userDetail(Map<String, Object> umap) {
        logger.info("userDetail Logic");
       List<Map<String,Object>> list = new ArrayList<>();
       list=cardDao.getusers(umap);
       List<Map<String,Object>> consultList=cardDao.consultList(umap);
       if(consultList!=null && consultList.size()>0){
        Map<String,Object> cMap=new HashMap<>();
        cMap.put("consults", consultList);
        list.add(1,cMap);
       }
    return list;

    }


    public int consultInsert(Map<String, Object> umap) {
        int result =0;
        result=cardDao.consultInsert(umap);
        return result;
    }


    public int consultDelete(int tb_num) {
        int result = 0;
        result=cardDao.consultDelete(tb_num);
        return result;
    }
}
