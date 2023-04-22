package com.linde.domain.Student;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentDeliver {
    private String companyName;
    private String positionName;
    private LocalDateTime deliverTime;
    private Integer deliverStatus;
}
