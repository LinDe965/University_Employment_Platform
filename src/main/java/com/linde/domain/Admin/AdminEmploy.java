package com.linde.domain.Admin;

import lombok.Data;

import java.time.Year;

@Data
public class AdminEmploy {
    private String studentName;
    private String studentTel;
    private String studentSubject;
    private Year studentEndYear;
    private String companyName;
    private String companyIndustry;
    private String positionName;
}
