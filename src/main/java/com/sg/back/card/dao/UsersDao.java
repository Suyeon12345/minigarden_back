package com.sg.back.card.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDao {
Logger logger = LoggerFactory.getLogger(UsersDao.class);
    @Autowired
    SqlSessionTemplate sqlSessionTemplate=null;
    public List<Map<String, Object>> getusers(Map<String, Object> umap) {
        logger.info("carddao : getUsers-dao");
        List<Map<String,Object>> usersList=null;
        usersList=sqlSessionTemplate.selectList("usersList",umap);
        return usersList;
    }
    
}
