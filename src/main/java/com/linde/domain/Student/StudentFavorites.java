package com.linde.domain.Student;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentFavorites {
    private String companyName;

    private String companyHrName;

    private String positionName;

    private LocalDateTime studentFavoritesTime;

    private Integer favoritesStatus;

}
