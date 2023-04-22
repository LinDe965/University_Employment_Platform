package com.linde.service;

import com.linde.domain.Hr.HrStudentInterview;
import com.linde.domain.Interview;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linde.domain.Student.StudentInterview;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Linde
 * @since 2023-04-17
 */
public interface IInterviewService extends IService<Interview> {
    List<HrStudentInterview> getStudentInterviewByHrId(String companyHrId);
    List<StudentInterview> getStudentInterviewByStudentId(String studentId);
}
