package com.linde.mapper;

import com.linde.domain.Hr.HrStudentInterview;
import com.linde.domain.Interview;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linde.domain.Student.StudentInterview;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface InterviewMapper extends BaseMapper<Interview> {

    //hr端面试管理模糊搜索
    @Select("select " +
            "stu.student_name,pos.position_name," +
            "interview.interview_id," +
            "interview.interview_address," +
            "interview.interview_time,interview.interview_status," +
            "interview.interview_student_status " +
            "from tbl_students as stu " +
            "JOIN tbl_interview as interview on stu.student_id = interview.student_id " +
            "JOIN tbl_position as pos on pos.position_id = interview.position_id " +
            "JOIN tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "where hr.company_hr_id = #{companyHrId} and " +
            "stu.student_name LIKE CONCAT('%', #{studentName}, '%');")
    List<HrStudentInterview> getStudentInterviewLikeByHr(String companyHrId,String studentName);

    @Select("select " +
            "stu.student_name,pos.position_name," +
            "interview.interview_id," +
            "interview.interview_address," +
            "interview.interview_time,interview.interview_status," +
            "interview.interview_student_status " +
            "from tbl_students as stu " +
            "JOIN tbl_interview as interview on stu.student_id = interview.student_id " +
            "JOIN tbl_position as pos on pos.position_id = interview.position_id " +
            "JOIN tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "where hr.company_hr_id = #{companyHrId};")
    List<HrStudentInterview> getStudentInterviewByHrId(String companyHrId);

    @Select("SELECT interview.interview_id,com.company_name,hr.company_hr_name,pos.position_name," +
            "interview.interview_time," +
            "interview.interview_status," +
            "interview.interview_student_status " +
            "from tbl_interview as interview " +
            "join tbl_position as pos on pos.position_id = interview.position_id " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where interview.student_id = #{studentId};")
    List<StudentInterview> getStudentInterviewByStudentId(String studentId);


    //stu面试模糊搜索
    @Select("SELECT interview.interview_id,com.company_name,hr.company_hr_name,pos.position_name," +
            "interview.interview_time," +
            "interview.interview_status," +
            "interview.interview_student_status " +
            "from tbl_interview as interview " +
            "join tbl_position as pos on pos.position_id = interview.position_id " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where interview.student_id = #{studentId} and pos.position_name LIKE CONCAT('%', #{positionName}, '%');")
    List<StudentInterview> getStudentInterviewLikeByStudent(String studentId,String positionName);


}
