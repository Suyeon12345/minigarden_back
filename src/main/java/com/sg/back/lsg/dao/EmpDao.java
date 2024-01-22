package com.sg.back.lsg.dao;

import com.sg.back.lsg.vo.EmpVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Repository
public class EmpDao implements EmpDaoInter{
    Logger logger = LoggerFactory.getLogger(EmpDao.class);
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    public List<EmpVO> empList() {
        logger.info("empList");
        List<EmpVO> nList = sqlSessionTemplate.selectList("getEmpList");
        logger.info(nList.toString());
        return nList;
    }

    public int empUpdate(Map<String, Object> eMap) {
        logger.info("empUpdate");
        int result = 0;
        try {
            result = sqlSessionTemplate.update("empUpdate", eMap);
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return result;
    }

    public int empDelete(int e_code) {
        logger.info("empDelete");
        int result = 0;
        try {
            result = sqlSessionTemplate.delete("empDelete", e_code);
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return result;
    }

   /* public List<EmpVO> getEmpList() {
        List<EmpVO> getEList = sqlSessionTemplate.selectList("getEmpList");
        return getEList;
    }*/

//2)
/*public List<EmpVO> getEmpList() {
    logger.info("getEmpList");
    // MyBatis의 쿼리를 통해 직원 목록을 가져오도록 수정
    return sqlSessionTemplate.selectList("getEmpList");
}*/


    ////////////////// VER.4 ///////////////////////////////////////////
    @Override
    public List<EmpVO> getEmpList() {
        logger.info("gpt-getEmpList");
        return sqlSessionTemplate.selectList("getEmpList");
    }
    //업로드
    // EmpVO를 사용하여 데이터베이스에 추가
/*    public void insertEmp(EmpVO empVO) {
        try {
            sqlSessionTemplate.insert("insertEmp", empVO);
        } catch (Exception e) {
            logger.error("Error inserting emp", e);
            throw new RuntimeException("Error inserting emp", e);
        }
    }*/
}
