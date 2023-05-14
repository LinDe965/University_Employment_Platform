package com.linde.service.impl;

import com.linde.domain.Student.StudentOneResumes;
import com.linde.domain.Students;
import com.linde.mapper.StudentsMapper;
import com.linde.service.IStudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Linde
 * @since 2023-04-02
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements IStudentsService {


    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public boolean updateStudentsPasswordById(String studentId,String password) {
        Students students = new Students();
        students.setStudentId(studentId);
        students.setPassword(password);
        return studentsMapper.updateById(students) > 0;
    }

    @Override
    public StudentOneResumes getStudentResumesByStudentId(String studentId) {
        return studentsMapper.getStudentsResumesByStudentId(studentId);
    }

    @Override
    public List<Students> getStudentsInformationAll() {
        return studentsMapper.getStudentsInformationAll();
    }

    @Override
    public boolean updateStudentsInformationByAdmin(String studentId, String studentName, Integer studentAge, String studentTel, String studentDepartment, String studentSubject, Year studentEndYear, Integer deleted) {
        return studentsMapper.updateStudentsInformationByAdmin(studentId, studentName, studentAge, studentTel, studentDepartment, studentSubject, studentEndYear, deleted) > 0;
    }
}
