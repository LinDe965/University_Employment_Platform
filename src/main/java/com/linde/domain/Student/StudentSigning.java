package com.linde.domain.Student;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentSigning {
    private String companyName;
    private String companyHrName;
    private String positionName;
    private LocalDateTime signingTime;
    private Integer signingStudentStatus;
}
