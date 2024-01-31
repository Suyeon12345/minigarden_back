package com.sg.back.angel.vo;

import lombok.Data;

import java.util.Date;

@Data
public class AngelVO {
    private Integer PG_NO;
    private String PG_NAME;
    private Date PG_START;
    private Date PG_END;
    private String PG_DAYSOFWEEK;
    private String PG_CATEGORY;
    private String PG_TEACHER;
    private String PG_CONTENT;
}
