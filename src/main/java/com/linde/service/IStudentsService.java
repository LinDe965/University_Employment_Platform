package com.linde.service;

import com.linde.domain.Student.StudentOneResumes;
import com.linde.domain.Students;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.Year;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Linde
 * @since 2023-04-02
 */
public interface IStudentsService extends IService<Students> {
    public boolean updateStudentsPasswordById(String studentId,String password);

    public StudentOneResumes getStudentResumesByStudentId(String studentId);

    List<Students> getStudentsInformationAll();

    boolean updateStudentsInformationByAdmin(String studentId, String studentName,
                                            Integer studentAge, String studentTel, String studentDepartment,
                                            String studentSubject, Year studentEndYear, Integer deleted
    );
}
