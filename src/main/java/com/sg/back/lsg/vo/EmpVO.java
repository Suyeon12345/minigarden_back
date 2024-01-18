package com.sg.back.lsg.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpVO {
    private int empCode;
    private String empName;
    private boolean empGender;
    private String empPNumber;

    @Builder
    public EmpVO(int empCode, String empName, boolean empGender, String empPNumber) {
        this.empCode = empCode;
        this.empName = empName;
        this.empGender = empGender;
        this.empPNumber = empPNumber;
    }
}
