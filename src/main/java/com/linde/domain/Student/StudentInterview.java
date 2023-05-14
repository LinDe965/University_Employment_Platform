package com.linde.domain.Student;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class StudentInterview {
    private String interviewId;

    private String companyName;

    private String companyHrName;

    private String positionName;

    private LocalDateTime interviewTime;

    private Integer interviewStudentStatus;

    private Integer interviewStatus;
}
