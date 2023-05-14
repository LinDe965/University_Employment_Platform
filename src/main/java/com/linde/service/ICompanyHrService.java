package com.linde.service;

import com.linde.domain.Admin.AdminHr;
import com.linde.domain.CompanyHr;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linde.domain.Hr.CompanyByHr;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Linde
 * @since 2023-04-03
 */
public interface ICompanyHrService extends IService<CompanyHr> {
    List<AdminHr> getCompanyHrAllByAdmin();

    List<AdminHr> getCompanyHrAllLikeByAdmin(String companyHrName);

    CompanyByHr getCompanyHrDetailByCompanyHrId(String companyHrId);
}
