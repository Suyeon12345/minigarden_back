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

    public void deptCreate(Map<String, Object> pmap){
        log.info("deptCreate-deptlogic 호출");
        deptDao.deptCreate(pmap);
     
    }
}
