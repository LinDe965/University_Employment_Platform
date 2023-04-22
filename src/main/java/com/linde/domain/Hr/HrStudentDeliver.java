package com.linde.domain.Hr;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HrStudentDeliver {
    private String studentName;
    private String studentSubject;
    private String positionName;
    private Integer deliverStatus;
    private LocalDateTime deliverTime;
}
