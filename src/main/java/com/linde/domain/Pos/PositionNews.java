package com.linde.domain.Pos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PositionNews {
    private String positionId;

    private String companyName;

    private String companyAddress;

    private String companyIndustry;

    private String companyHrName;

    private String positionName;

    private Integer positionSalary;

    private LocalDateTime positionCreateTime;
}
