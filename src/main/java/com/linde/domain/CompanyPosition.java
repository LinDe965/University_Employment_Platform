package com.linde.domain;

import lombok.Data;

@Data
public class CompanyPosition {
    private Company company;

    private CompanyHr companyHr;

    private Post post;

    private Position position;
}
