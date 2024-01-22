package com.sg.back.flower.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.back.flower.dao.deptDao;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class deptLogic {

    @Autowired
    deptDao deptDao = null;
    
    public List<Map<String, Object>> deptList(Map<String, Object> pmap){
        log.info("deptlist-deptlogic 호출");
        List<Map<String, Object>> list = new ArrayList<>();
        list = deptDao.deptList(pmap);
        return list;
    }

        
    public List<Map<String, Object>> deptDetail(Map<String, Object> pmap){
        log.info("deptDetail-deptlogic 호출");
        List<Map<String, Object>> list = new ArrayList<>();
        list = deptDao.deptDetail(pmap);
        return list;
    }

    public void deptInsert(Map<String, Object> pmap){
        log.info("deptInsert-deptlogic 호출");
        deptDao.deptInsert(pmap);
     
    }

    public void deptUpdate(Map<String, Object> pmap){
        log.info("deptUpdate-deptlogic 호출");
        deptDao.deptUpdate(pmap);
     
    }


    public void deptDelete(Map<String, Object> pmap){
        log.info("deptUpdate-deptlogic 호출");
        deptDao.deptDelete(pmap);
     
    }
}
