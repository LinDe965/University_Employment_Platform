package com.linde.domain.Pos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PositionDetail {

    //com
    private String companyName;

    private String companyAddress;

    private String companyIndustry;

    private String companyIntroduction;

    private String companyDetail;

    //pos
    private String positionName;

    private Integer positionRecruitNumber;

    private Integer positionSalary;

    private String positionRequire;

    private LocalDateTime positionCreateTime;

    //hr
    private String companyHrName;

    private String companyHrTel;

    private String companyHrEmail;
}
