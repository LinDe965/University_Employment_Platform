package com.linde.mapper;

import com.linde.domain.Hr.HrStudentDeliver;
import com.linde.domain.Hr.HrStudentResumes;
import com.linde.domain.StudentResumes;
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
 * @since 2023-04-02
 */

@Mapper
public interface StudentResumesMapper extends BaseMapper<StudentResumes> {
    @Select("select stu.student_id,stu.student_name," +
            "stu.student_tel,student_email,stu.student_subject," +
            "stu.student_end_year," +
            "res.resume_experience,res.resume_skills," +
            "res.resume_evaluation,res.resume_salary_expectation " +
            "from tbl_students as stu " +
            "JOIN tbl_student_resumes as res on stu.student_id = res.student_id " +
            "JOIN tbl_deliver as deliver on stu.student_id = deliver.student_id " +
            "JOIN tbl_position as pos on deliver.position_id = pos.position_id " +
            "JOIN tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "where hr.company_hr_id = #{companyHrId};")
    public List<HrStudentResumes> getStudentResumesByCompanyHrId(String companyHrId);

    @Select("select stu.student_id,stu.student_name,stu.student_tel,student_email,stu.student_subject,stu.student_end_year," +
            "res.resume_experience,res.resume_skills,res.resume_evaluation,res.resume_salary_expectation " +
            "from tbl_students as stu " +
            "JOIN tbl_student_resumes as res on stu.student_id = res.student_id " +
            "JOIN tbl_deliver as deliver on stu.student_id = deliver.student_id " +
            "JOIN tbl_position as pos on deliver.position_id = pos.position_id " +
            "JOIN tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "where hr.company_hr_id = #{companyHrId} and " +
            "stu.student_name LIKE CONCAT('%', #{studentName}, '%');")
    List<HrStudentResumes> getStudentResumesLikeByHr(String companyHrId,String studentName);
}
