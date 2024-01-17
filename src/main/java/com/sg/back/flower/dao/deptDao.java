package com.sg.back.flower.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class deptDao {
    
    @Autowired
    SqlSessionTemplate sqlSessionTemplate = null;

    public List<Map<String, Object>> deptList(Map<String, Object> pmap){
        
        log.info("deptlist-deptdao 호출");

        List<Map<String, Object>> list =sqlSessionTemplate.selectList("deptMapper.deptList");
        
        return list;

    }

    public void deptCreate(Map<String, Object> pmap){
        
        log.info("deptCreate-deptdao 호출");

        sqlSessionTemplate.insert("deptMapper.deptCreate", pmap);
        

    }
}
