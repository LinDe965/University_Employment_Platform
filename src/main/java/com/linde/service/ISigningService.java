package com.linde.service;

import com.linde.domain.Admin.AdminEmploy;
import com.linde.domain.Hr.HrStudentSigning;
import com.linde.domain.Signing;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linde.domain.Student.StudentInterview;
import com.linde.domain.Student.StudentSigning;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Linde
 * @since 2023-04-17
 */
public interface ISigningService extends IService<Signing> {
    List<HrStudentSigning> getStudentSigningByHrId(String companyHrId);

    List<StudentSigning> getStudentSigningByStudentId(String studentId);

    List<AdminEmploy> getStudentSigningByAdmin();
}
