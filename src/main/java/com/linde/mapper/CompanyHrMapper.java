package com.linde.mapper;

import com.linde.domain.Admin.AdminHr;
import com.linde.domain.CompanyHr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linde.domain.Hr.CompanyByHr;
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
    @Select("select hr.company_hr_id," +
            "com.company_name,hr.company_hr_name,hr.company_hr_tel,hr.company_hr_email, " +
            "hr.deleted " +
            "from tbl_company_hr as hr " +
            "join tbl_company as com on com.company_id = hr.company_id ;")
    List<AdminHr> getCompanyHrAllByAdmin();

    @Select("select hr.company_hr_id," +
            "com.company_name,hr.company_hr_name,hr.company_hr_tel,hr.company_hr_email, " +
            "hr.deleted " +
            "from tbl_company_hr as hr " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where " +
            "hr.company_hr_name LIKE CONCAT('%', #{companyHrName}, '%');")
    List<AdminHr> getCompanyHrAllLikeByAdmin(String companyHrName);

    @Select("select com.company_id,com.company_name,com.company_address," +
            "hr.company_hr_id,hr.company_hr_name,hr.company_hr_tel,hr.company_hr_email " +
            "from tbl_company as com " +
            "join tbl_company_hr as hr on hr.company_id = com.company_id " +
            "where hr.company_hr_id = #{companyHrId};")
    CompanyByHr getCompanyHrDetailByCompanyHrId(String companyHrId);
}
