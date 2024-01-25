package com.sg.back.garden.logic;

import com.sg.back.garden.controller.Garden;
import com.sg.back.garden.dao.GardenDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GardenLogic {

    Logger logger = LoggerFactory.getLogger(GardenLogic.class);

    @Autowired
    GardenDao gardenDao = null;

    public List<Map<String, Object>> getOK(Map<String, Object> rmap) {
        logger.info("Garden Logic: getOK");
        List<Map<String, Object>> gList = null;
        gList = gardenDao.getOK(rmap);
        return gList;
    }

    public List<Map<String, Object>> getDeptData() {
        logger.info("Garden Logic: getDeptData");
        List<Map<String, Object>> dList = null;
        dList = gardenDao.getDeptData();
        return dList;
    }
}
