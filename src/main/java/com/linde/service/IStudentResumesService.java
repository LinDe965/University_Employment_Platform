package com.linde.service;

import com.linde.domain.Hr.HrStudentDeliver;
import com.linde.domain.Hr.HrStudentResumes;
import com.linde.domain.StudentResumes;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Linde
 * @since 2023-04-02
 */
public interface IStudentResumesService extends IService<StudentResumes> {
    public List<HrStudentResumes> getStudentResumesByCompanyHrId(String companyHrId);


}
