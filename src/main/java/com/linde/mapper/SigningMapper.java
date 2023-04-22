package com.linde.mapper;

import com.linde.domain.Admin.AdminEmploy;
import com.linde.domain.Hr.HrStudentInterview;
import com.linde.domain.Hr.HrStudentSigning;
import com.linde.domain.Signing;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linde.domain.Student.StudentInterview;
import com.linde.domain.Student.StudentSigning;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Linde
 * @since 2023-04-17
 */
@Mapper
public interface SigningMapper extends BaseMapper<Signing> {
    @Select("select stu.student_name,pos.position_name,sign.signing_address,sign.signing_time,sign.signing_status " +
            "from tbl_students as stu " +
            "RIGHT JOIN tbl_signing as sign on stu.student_id = sign.student_id " +
            "RIGHT JOIN tbl_position as pos on pos.position_id = sign.position_id " +
            "RIGHT JOIN tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "where hr.company_hr_id = #{companyHrId};")
    List<HrStudentSigning> getStudentSigningByHrId(String companyHrId);

    @Select("SELECT com.company_name,hr.company_hr_name,pos.position_name,sign.signing_time,sign.signing_student_status " +
            "from tbl_signing as sign " +
            "join tbl_position as pos on pos.position_id = sign.position_id " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where sign.student_id = #{studentId};")
    List<StudentSigning> getStudentSigningByStudentId(String studentId);


    @Select("select stu.student_name,stu.student_tel,stu.student_subject,stu.student_end_year,com.company_name,com.company_industry,pos.position_name " +
            "from tbl_students as stu " +
            "join tbl_signing as sign on sign.student_id = stu.student_id " +
            "join tbl_position as pos on pos.position_id = sign.position_id " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where signing_student_status = 1;")
    List<AdminEmploy> getStudentSigningByAdmin();
}
