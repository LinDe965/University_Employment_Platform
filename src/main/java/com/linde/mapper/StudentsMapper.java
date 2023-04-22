package com.linde.mapper;

import com.linde.domain.Student.StudentOneResumes;
import com.linde.domain.Students;
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
public interface StudentsMapper extends BaseMapper<Students> {

    @Select("select stu.student_name, " +
            "stu.student_sex, " +
            "stu.student_age, " +
            "stu.student_tel, " +
            "stu.student_email, " +
            "stu.student_id_cards, " +
            "stu.student_end_year, " +
            "stu.student_subject, " +
            "stu.student_department, " +
            "res.resume_experience, " +
            "res.resume_skills, " +
            "res.resume_evaluation, " +
            "res.resume_salary_expectation " +
            "from tbl_students as stu " +
            "join tbl_student_resumes as res on res.student_id = stu.student_id " +
            "where stu.student_id = #{studentId};")
    StudentOneResumes getStudentsResumesByStudentId(String studentId);
}
