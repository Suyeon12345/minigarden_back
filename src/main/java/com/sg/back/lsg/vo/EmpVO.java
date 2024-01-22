package com.sg.back.lsg.vo;

import com.sg.back.lsg.annotaion.ExcelHeader;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@EntityScan
@NoArgsConstructor
public class EmpVO {
    @ExcelHeader(name = "사원번호")
    private int e_code;
    @ExcelHeader(name = "이름")
    private String e_name;
    @ExcelHeader(name = "성별")
    private String e_gender;
    @ExcelHeader(name = "전화번호")
    private String e_phone;

    @Builder
    public EmpVO(int e_code, String e_name, String e_gender, String e_phone) {
        this.e_code = e_code;
        this.e_name = e_name;
        this.e_gender = e_gender;
        this.e_phone = e_phone;
    }

    @Override
    public String toString() {
        return "EmpVO{" +
                "e_code=" + e_code +
                ", e_name='" + e_name + '\'' +
                ", e_gender='" + e_gender + '\'' +
                ", e_phone='" + e_phone + '\'' +
                '}';
    }
}
