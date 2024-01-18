package com.sg.back.lsg.logic;

import com.sg.back.lsg.dao.EmpDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmpLogic {
    Logger logger = LoggerFactory.getLogger(EmpLogic.class);
    @Autowired
    private EmpDao empDao = null;

    public List<Map<String, Object>> empList(Map<String, Object> eMap) {
        logger.info("empList");
        List<Map<String , Object>> nList = null;
        nList = empDao.empList(eMap);
        return nList;
    }

    public List<Map<String, Object>> empDetail(Map<String, Object> eMap) {
        logger.info("empDetail");
        List<Map<String, Object>> nList = null;
        nList = empDao.empList(eMap);
        return nList;
    }

    public int empUpdate(Map<String, Object> eMap) {
        logger.info("empUpdate");
        int result = 0;
        result = empDao.empUpdate(eMap);
        return result;
    }

    public int empDelete(int e_code) {
        logger.info("empDelete");
        int result = 0;
        result = empDao.empDelete(e_code);
        return result;
    }
}
