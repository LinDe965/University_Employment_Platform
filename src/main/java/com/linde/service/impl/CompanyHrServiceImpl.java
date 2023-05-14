package com.linde.service.impl;

import com.linde.domain.Admin.AdminHr;
import com.linde.domain.CompanyHr;
import com.linde.domain.Hr.CompanyByHr;
import com.linde.mapper.CompanyHrMapper;
import com.linde.service.ICompanyHrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Linde
 * @since 2023-04-03
 */
@Service
public class CompanyHrServiceImpl extends ServiceImpl<CompanyHrMapper, CompanyHr> implements ICompanyHrService {

    @Autowired
    private CompanyHrMapper companyHrMapper;

    @Override
    public List<AdminHr> getCompanyHrAllByAdmin() {
        return companyHrMapper.getCompanyHrAllByAdmin();
    }

    @Override
    public List<AdminHr> getCompanyHrAllLikeByAdmin(String companyHrName) {
        return companyHrMapper.getCompanyHrAllLikeByAdmin(companyHrName);
    }

    @Override
    public CompanyByHr getCompanyHrDetailByCompanyHrId(String companyHrId) {
        return companyHrMapper.getCompanyHrDetailByCompanyHrId(companyHrId);
    }
}
