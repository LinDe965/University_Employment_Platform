package com.linde.domain;


import lombok.Data;

@Data
public class StudentsDetail {
    private Students students;
    private StudentStatus studentStatus;
    private StudentFavorites studentFavorites;
    private StudentResumes studentResumes;
}
