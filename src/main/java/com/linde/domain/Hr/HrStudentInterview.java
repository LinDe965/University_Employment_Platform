package com.linde.domain.Hr;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HrStudentInterview {
    private String studentName;

    private String positionName;

    private Integer interviewStatus;

    private LocalDateTime interviewTime;

    private String interviewAddress;
}
