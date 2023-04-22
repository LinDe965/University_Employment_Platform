package com.linde.service.impl;

import com.linde.domain.Hr.HrStudentInterview;
import com.linde.domain.Interview;
import com.linde.domain.Student.StudentInterview;
import com.linde.mapper.InterviewMapper;
import com.linde.service.IInterviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Linde
 * @since 2023-04-17
 */
@Service
public class InterviewServiceImpl extends ServiceImpl<InterviewMapper, Interview> implements IInterviewService {

    @Autowired
    private InterviewMapper interviewMapper;

    @Override
    public List<HrStudentInterview> getStudentInterviewByHrId(String companyHrId) {
        return interviewMapper.getStudentInterviewByHrId(companyHrId);
    }

    @Override
    public List<StudentInterview> getStudentInterviewByStudentId(String studentId) {
        return interviewMapper.getStudentInterviewByStudentId(studentId);
    }
}
