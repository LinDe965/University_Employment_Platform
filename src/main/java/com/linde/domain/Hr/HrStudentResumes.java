package com.linde.domain.Hr;

import lombok.Data;

import java.time.Year;

@Data
public class HrStudentResumes {
    private String studentName;

    private String studentTel;

    private String studentEmail;

    private String studentSubject;

    private Year studentEndYear;

    private String resumeExperience;

    private String resumeSkills;

    private String resumeEvaluation;

    private String resumeSalaryExpectation;
}
