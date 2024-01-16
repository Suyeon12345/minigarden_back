package com.sg.back.card.logic;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.back.card.dao.UsersDao;


@Service
public class UsersLogic {
 Logger logger = LoggerFactory.getLogger(CardLogic.class);

    @Autowired
    UsersDao usersDao = null;
    public List<Map<String, Object>> getusers(Map<String, Object> umap) {
        logger.info("cardLogic: getCard");
        List<Map<String,Object>>usersList=null;
        usersList=usersDao.getusers(umap);
        return usersList;
    }
    
}
