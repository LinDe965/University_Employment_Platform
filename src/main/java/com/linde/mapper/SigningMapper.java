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

    //hr端面试管理模糊搜索
    @Select("select stu.student_name,pos.position_name," +
            "sign.signing_id," +
            "sign.signing_address," +
            "sign.signing_time," +
            "sign.signing_student_status," +
            "sign.signing_status " +
            "from tbl_students as stu " +
            "JOIN tbl_signing as sign on stu.student_id = sign.student_id " +
            "JOIN tbl_position as pos on pos.position_id = sign.position_id " +
            "JOIN tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "where hr.company_hr_id = #{companyHrId} and " +
            "stu.student_name LIKE CONCAT('%', #{studentName}, '%');")
    List<HrStudentSigning> getStudentSigningLikeByHr(String companyHrId,String studentName);

    //hr端查看所有的面试信息
    @Select("select stu.student_name,pos.position_name," +
            "sign.signing_id," +
            "sign.signing_address," +
            "sign.signing_time," +
            "sign.signing_student_status," +
            "sign.signing_status " +
            "from tbl_students as stu " +
            "JOIN tbl_signing as sign on stu.student_id = sign.student_id " +
            "JOIN tbl_position as pos on pos.position_id = sign.position_id " +
            "JOIN tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "where hr.company_hr_id = #{companyHrId};")
    List<HrStudentSigning> getStudentSigningByHrId(String companyHrId);

    @Select("SELECT sign.signing_id," +
            "com.company_name,hr.company_hr_name,pos.position_name,sign.signing_time," +
            "sign.signing_status,sign.signing_student_status " +
            "from tbl_signing as sign " +
            "join tbl_position as pos on pos.position_id = sign.position_id " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where sign.student_id = #{studentId};")
    List<StudentSigning> getStudentSigningByStudentId(String studentId);

    //模糊搜索
    @Select("SELECT sign.signing_id," +
            "com.company_name,hr.company_hr_name,pos.position_name,sign.signing_time," +
            "sign.signing_status,sign.signing_student_status " +
            "from tbl_signing as sign " +
            "join tbl_position as pos on pos.position_id = sign.position_id " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where sign.student_id = #{studentId} and pos.position_name LIKE CONCAT('%', #{positionName}, '%');")
    List<StudentSigning> getStudentSigningLikeByStudent(String studentId,String positionName);

    //admin 就业信息管理查看所有数据
    @Select("select stu.student_name,stu.student_tel,stu.student_subject,stu.student_end_year," +
            "com.company_name,com.company_industry,pos.position_name " +
            "from tbl_students as stu " +
            "join tbl_signing as sign on sign.student_id = stu.student_id " +
            "join tbl_position as pos on pos.position_id = sign.position_id " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where signing_student_status = 1;")
    List<AdminEmploy> getStudentSigningByAdmin();

    //admin 就业信息管理模糊搜索
    @Select("select stu.student_name,stu.student_tel,stu.student_subject,stu.student_end_year," +
            "com.company_name,com.company_industry,pos.position_name " +
            "from tbl_students as stu " +
            "join tbl_signing as sign on sign.student_id = stu.student_id " +
            "join tbl_position as pos on pos.position_id = sign.position_id " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where signing_student_status = 1 and stu.student_name LIKE CONCAT('%', #{studentName}, '%');")
    List<AdminEmploy> getStudentSigningLikeByAdmin(String studentName);
}
