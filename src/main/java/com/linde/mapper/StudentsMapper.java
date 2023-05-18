package com.linde.mapper;

import com.linde.domain.Student.StudentOneResumes;
import com.linde.domain.Students;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Year;
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

    @Update("update tbl_students set " +
            "student_name = #{studentName}," +
            "student_age = #{studentAge}," +
            "student_tel = #{studentTel}," +
            "student_department = #{studentDepartment}," +
            "student_subject = #{studentSubject}," +
            "student_end_year = #{studentEndYear}," +
            "deleted = #{deleted} " +
            "where student_id = #{studentId};")
    int updateStudentsInformationByAdmin( String studentId, String studentName,
                                      Integer studentAge, String studentTel, String studentDepartment,
                                      String studentSubject, Year studentEndYear,Integer deleted
    );

    @Select("select * from tbl_students;")
    List<Students> getStudentsInformationAll();

    @Select("select stu.student_id, stu.student_name,stu.student_sex, " +
            "stu.student_age, stu.student_tel, stu.student_email, " +
            "stu.student_id_cards,stu.student_end_year, " +
            "stu.student_subject, stu.student_department," +
            "stu.deleted ," +
            "res.resume_experience, res.resume_skills, " +
            "res.resume_evaluation, " +
            "res.resume_salary_expectation " +
            "from tbl_students as stu " +
            "join tbl_student_resumes as res on res.student_id = stu.student_id " +
            "where stu.student_id = #{studentId} and stu.deleted = 0;")
    StudentOneResumes getStudentsResumesByStudentId(String studentId);



}
