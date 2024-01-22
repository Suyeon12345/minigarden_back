package com.sg.back.lsg.logic;

import com.sg.back.lsg.dao.EmpDao;
import com.sg.back.lsg.vo.EmpVO;
import lombok.RequiredArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpLogic implements EmpLogicInter{
    Logger logger = LoggerFactory.getLogger(EmpLogic.class);
    @Autowired
    private EmpDao empDao;

    public List<EmpVO> empList() {
        logger.info("empList");
        List<EmpVO> nList = null;
        nList = empDao.empList();
        return nList;
    }

   /* public List<Map<String, Object>> empDetail(Map<String, Object> eMap) {
        logger.info("empDetail");
        List<Map<String, Object>> nList = null;
        nList = empDao.empList(eMap);
        return nList;
    }*/

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

    //////////////////////// VER.4 ///////////////////////////////
    public List<EmpVO> excelDown() {
        logger.info("excelDown");
        List<EmpVO> nList = null;
        nList = empDao.empList();
        return nList;
    }

    /*public byte[] generateExcel() {
        List<EmpVO> empList = empDao.getEmpList();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employee List");

        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"사원번호", "이름", "성별", "전화번호"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Populate data rows
        for (int rowNum = 1; rowNum <= empList.size(); rowNum++) {
            Row row = sheet.createRow(rowNum);
            EmpVO emp = empList.get(rowNum - 1);
            row.createCell(0).setCellValue(emp.getE_code());
            row.createCell(1).setCellValue(emp.getE_name());
            row.createCell(2).setCellValue(emp.getE_gender());
            row.createCell(3).setCellValue(emp.getE_phone());
        }

        // Convert workbook to byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }*/

    //1)
    /*public List<EmpVO> excelDown() {

    }*/

    //2)
//    public List<EmpVO> getEmpVO(boolean excelDown, HttpServletResponse response) {
//        logger.info("getEmpVO");
//        // Response 객체를 DAO에 직접 전달하지 않고, 필요한 데이터만을 리턴하도록 수정
//        return empDao.getEmpList();
//    }

    ////////////////////// VER.3 ////////////////////////////////
    @Override
    public List<EmpVO> getEmpList() {
            logger.info("gpt-getEmpList");
        return empDao.getEmpList();
    }
    //업로드
    /// 엑셀 데이터 처리 로직
/*    public List<EmpVO> excelData(MultipartFile file) {
        logger.info("EmpLogic - excelData");
        try (Workbook workbook = WorkbookFactory.create(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            List<EmpVO> empList = new ArrayList<>();

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                EmpVO empVO = new EmpVO();
                empVO.setE_code(Integer.parseInt(row.getCell(0).toString()));
                empVO.setE_name(row.getCell(1).toString());
                empVO.setE_gender(row.getCell(2).toString());
                empVO.setE_phone(row.getCell(3).toString());

                empList.add(empVO);
            }

            return empList;
        } catch (Exception e) {
            throw new RuntimeException("Error processing Excel data", e);
        }
    }
    // EmpVO 리스트를 사용하여 DB에 추가
    public void insertEmpList(List<EmpVO> empList) {
        for (EmpVO empVO : empList) {
            empDao.insertEmp(empVO);
        }
    }*/
}
