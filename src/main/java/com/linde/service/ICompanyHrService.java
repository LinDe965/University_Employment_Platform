package com.linde.service;

import com.linde.domain.CompanyHr;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Linde
 * @since 2023-04-03
 */
public interface ICompanyHrService extends IService<CompanyHr> {

    public boolean updateCompanyHrPasswordById(Long companyHrId,String password);
}
