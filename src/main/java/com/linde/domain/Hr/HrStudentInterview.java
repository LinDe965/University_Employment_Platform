package com.linde.domain.Hr;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HrStudentInterview {
    private String interviewId;

    private String studentName;

    private String positionName;

    private Integer interviewStatus;

    private LocalDateTime interviewTime;

    private String interviewAddress;

    private Integer interviewStudentStatus;

   // private String companyHrId;
}
