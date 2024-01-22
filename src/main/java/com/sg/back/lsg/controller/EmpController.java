package com.sg.back.lsg.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.google.gson.Gson;
import com.sg.back.lsg.logic.EmpLogic;
import com.sg.back.lsg.vo.EmpVO;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp/*")
@RequiredArgsConstructor
public class EmpController {
    Logger logger = LoggerFactory.getLogger(EmpController.class);
    /*private static final int MAX_ROW = 5000;
    @Autowired
    private ExcelUtils excelUtils;*/
    @Autowired
    private EmpLogic empLogic;

    // 직원 조회
    @GetMapping("empList")
    public List<EmpVO> empList() {
        logger.info("empList");
        return empLogic.empList();
    }

    // 직원 상세조회
    /*@GetMapping("empDetail")
    public String empDetail(@RequestParam Map<String, Object> eMap) {
        logger.info("empDetail");
        List<Map<String, Object>> eList = null;
        eList = empLogic.empDetail(eMap);
        Gson g = new Gson();
        String temp = g.toJson(eList);
        return temp;
    }*/

    // 직원 수정
    @PutMapping("empUpdate")
    public String empUpdate(@RequestBody Map<String, Object> eMap) {
        logger.info("empUpdate");
        logger.info(eMap.toString());
        int result = 0;
        result = empLogic.empUpdate(eMap);
        return String.valueOf(result);
    }

    // 직원 삭제
    @GetMapping("empDelete")
    public String empDelete(int e_code) {
        logger.info("empDelete");
        int result = 0;
        result = empLogic.empDelete(e_code);
        Gson g = new Gson();
        String temp = g.toJson(result);
        return temp;
    }

    // 조회된 직원 리스트 엑셀로 다운로드
/*    @GetMapping("excelDown")
    public ResponseEntity<byte[]> excelDown() {
        byte[] excelBytes = empLogic.generateExcel(); // 서비스에서 엑셀을 생성하는 메서드 호출

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "employee_list.xlsx"); // 다운로드할 파일명

        return ResponseEntity.ok().headers(headers).body(excelBytes);
    }*/

    //////////////// VER.4 ///////////////////////////////////////////
    @GetMapping("excelDown")
    public ResponseEntity</*Resource*/List<EmpVO>> excelDown() {
        try {
            logger.info("excelDown");

            // 엑셀 다운로드를 위한 데이터 조회
            List<EmpVO> eList = empLogic.excelDown();

            // 엑셀 파일 생성
            //Workbook wb = new XSSFWorkbook();
            Workbook wb = new SXSSFWorkbook();
            Sheet sheet = wb.createSheet("사원 목록");
            Row row;
            Cell cell;
            int rowNo = 0;

            // 테이블 헤더용 스타일
            CellStyle headStyle = wb.createCellStyle();
            headStyle.setBorderTop(BorderStyle.THIN);
            headStyle.setBorderBottom(BorderStyle.THIN);
            headStyle.setBorderLeft(BorderStyle.THIN);
            headStyle.setBorderRight(BorderStyle.THIN);
            headStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headStyle.setAlignment(HorizontalAlignment.CENTER);

            // 데이터용 경계 스타일 테두리만 지정
            CellStyle bodyStyle = wb.createCellStyle();
            bodyStyle.setBorderTop(BorderStyle.THIN);
            bodyStyle.setBorderBottom(BorderStyle.THIN);
            bodyStyle.setBorderLeft(BorderStyle.THIN);
            bodyStyle.setBorderRight(BorderStyle.THIN);

            // 헤더 생성
            row = sheet.createRow(rowNo++);
            cell = row.createCell(0);
            cell.setCellStyle(headStyle);
            cell.setCellValue("사원번호");
            cell = row.createCell(1);
            cell.setCellStyle(headStyle);
            cell.setCellValue("이름");
            cell = row.createCell(2);
            cell.setCellStyle(headStyle);
            cell.setCellValue("성별");
            cell = row.createCell(3);
            cell.setCellStyle(headStyle);
            cell.setCellValue("전화번호");

            // 데이터 생성
            for (EmpVO emp : eList) {
                row = sheet.createRow(rowNo++);
                cell = row.createCell(0);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(String.valueOf(emp.getE_code()));
                cell = row.createCell(1);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(String.valueOf(emp.getE_name()));
                cell = row.createCell(2);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(String.valueOf(emp.getE_gender()));
                cell = row.createCell(3);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(String.valueOf(emp.getE_phone()));
            }

            // 엑셀 파일을 ByteArray로 변환
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            wb.write(bos);
            wb.close();

            // ByteArray를 Resource로 변환
            ByteArrayResource resource = new ByteArrayResource(bos.toByteArray());

            // 파일 이름에 공백이 있는 경우 URL 인코딩 필요
            String filename = "employee_list.xlsx";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //headers.setContentDispositionFormData("attachment", filename);
            headers.setContentDispositionFormData("attachment", URLEncoder.encode(filename, StandardCharsets.UTF_8.toString()));
            headers.setContentLength(bos.size());

            /*return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(bos.size())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);*/
            return ResponseEntity.ok().body(eList);

        } catch (IOException e) {
            // 예외 처리
            logger.error("Error occurred while creating Excel file", e);
            // 예외 처리에 따른 응답 코드 설정
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**************************************************[[ 1 ]]************************************
    @GetMapping("excelDown")
    public void excelDown(HttpServletResponse response) {
        List<EmpVO> result = empLogic.excelDown();
        excelUtils.download(EmpVO.class, result, "download", response);
    }
    *************************************************************************************************/

//2)
   /* @GetMapping("excelDown")
    public ResponseEntity getUsersPointStats(HttpServletResponse response, boolean excelDownload){
        return ResponseEntity.ok(statsService.getUsersPointStats(response, excelDownload));
    }*/

    ////////////////////// VER.3 ////////////////////////////////////////
    @GetMapping
    public ResponseEntity<String> getEmpList() {
        List<EmpVO> employees = empLogic.getEmpList();
        String json = new Gson().toJson(employees);
        return ResponseEntity.ok(json);
    }

    @GetMapping("excelDown2")
    public ResponseEntity<byte[]> downloadExcel() throws IOException {
        List<EmpVO> employees = empLogic.getEmpList();
        byte[] excelBytes = generateExcel(employees);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "employees.xlsx");

        return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
    }

    private byte[] generateExcel(List<EmpVO> employees) throws IOException {
        try (Workbook workbook = new SXSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Employees");
            createHeaderRow(sheet);

            int rowNum = 1;
            for (EmpVO employee : employees) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(employee.getE_code());
                row.createCell(1).setCellValue(employee.getE_name());
                row.createCell(2).setCellValue(employee.getE_gender());
                row.createCell(3).setCellValue(employee.getE_phone());
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }

    private void createHeaderRow(Sheet sheet) {
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("사원 번호");
        header.createCell(1).setCellValue("이름");
        header.createCell(2).setCellValue("성별");
        header.createCell(3).setCellValue("휴대폰 번호");
    }
    // 업로드
    /*@PostMapping("/excelUp")
    public ResponseEntity<String> excelUp(@RequestParam("file") MultipartFile file) {
        try {
            // 서버에서 엑셀 다운로드 요청
            InputStream inputStream = file.getInputStream();
            List<EmpVO> empList = empLogic.excelData(inputStream);

            // 엑셀 파일의 내용을 DB에 추가
            empLogic.insertEmpList(empList);

            return ResponseEntity.ok("Excel upload and DB insert successful");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing Excel file");
        }
    }*/
}
