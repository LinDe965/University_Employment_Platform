package com.linde.domain.Student;

import lombok.Data;

import java.time.Year;

@Data
public class StudentOneResumes {
    private String studentName;

    private String studentSex;

    private Integer studentAge;

    private String studentTel;

    private String studentEmail;

    private String studentIdCards;

    private String studentDepartment;

    private String studentSubject;

    private Year studentEndYear;

    private String resumeExperience;

    private String resumeSkills;

    private String resumeEvaluation;

    private String resumeSalaryExpectation;
}
