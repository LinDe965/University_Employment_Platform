package com.linde.mapper;

import com.linde.domain.Admin.AdminHr;
import com.linde.domain.CompanyHr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Linde
 * @since 2023-04-03
 */
@Mapper
public interface CompanyHrMapper extends BaseMapper<CompanyHr> {
    @Select("select com.company_name,hr.company_hr_name,hr.company_hr_tel,hr.company_hr_email " +
            "from tbl_company_hr as hr " +
            "join tbl_company as com on com.company_id = hr.company_id;")
    List<AdminHr> getCompanyHrAllByAdmin();
}
