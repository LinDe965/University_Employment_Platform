package com.linde.domain.Hr;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HrStudentSigning {
    private String signingId;

    private String studentName;

    private String positionName;

    private Integer signingStatus;

    private LocalDateTime signingTime;

    private String signingAddress;

    private Integer signingStudentStatus;
}
