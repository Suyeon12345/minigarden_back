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
        
        log.info("deptlist-deptdao");

        List<Map<String, Object>> list =sqlSessionTemplate.selectList("deptMapper.deptList");
        
        return list;

    }


    public List<Map<String, Object>> deptDetail(Map<String, Object> pmap){
        
        log.info("deptDetail-deptdao");

        List<Map<String, Object>> list =sqlSessionTemplate.selectList("deptMapper.deptDetail", pmap);
        
        return list;

    }

    public void deptInsert(Map<String, Object> pmap){
        
        log.info("deptInsert-deptdao 호출");

        sqlSessionTemplate.insert("deptMapper.deptInsert", pmap);
        

    }

    public void deptUpdate(Map<String, Object> pmap){
        
        log.info("deptUpdate-deptdao 호출");

        sqlSessionTemplate.update("deptMapper.deptUpdate", pmap);
        

    }

    public void deptDelete(Map<String, Object> pmap){
        
        log.info("deptDelete-deptdao 호출");

        sqlSessionTemplate.delete("deptMapper.deptDelete", pmap);
        

    }
}
