package com.linde.service.impl;

import com.linde.domain.Company;
import com.linde.mapper.CompanyMapper;
import com.linde.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Linde
 * @since 2023-04-03
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

}
