package com.linde.domain.Admin;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminPosition {
    private String companyName;

    private String companyHrName;

    private String positionName;

    private Integer positionRecruitNumber;

    private Integer positionSalary;

    private String positionRequire;

    private LocalDateTime positionCreateTime;
}
