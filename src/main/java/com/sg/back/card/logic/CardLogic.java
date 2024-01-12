package com.sg.back.card.logic;

import java.util.List;
import java.util.Map;

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
}
