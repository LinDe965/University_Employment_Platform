package com.linde.service.impl;

import com.linde.domain.Hr.HrStudentDeliver;
import com.linde.domain.Hr.HrStudentResumes;
import com.linde.domain.StudentResumes;
import com.linde.mapper.StudentResumesMapper;
import com.linde.service.IStudentResumesService;
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
 * @since 2023-04-02
 */
@Service
public class StudentResumesServiceImpl extends ServiceImpl<StudentResumesMapper, StudentResumes> implements IStudentResumesService {

    @Autowired
    private StudentResumesMapper studentResumesMapper;

    @Override
    public List<HrStudentResumes> getStudentResumesByCompanyHrId(String companyHrId) {
        return studentResumesMapper.getStudentResumesByCompanyHrId(companyHrId);
    }
}
