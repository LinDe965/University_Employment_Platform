package com.linde.service.impl;

import com.linde.domain.Admin.AdminEmploy;
import com.linde.domain.Hr.HrStudentSigning;
import com.linde.domain.Signing;
import com.linde.domain.Student.StudentInterview;
import com.linde.domain.Student.StudentSigning;
import com.linde.mapper.SigningMapper;
import com.linde.service.ISigningService;
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
public class SigningServiceImpl extends ServiceImpl<SigningMapper, Signing> implements ISigningService {
    @Autowired
    private SigningMapper signingMapper;

    @Override
    public List<HrStudentSigning> getStudentSigningByHrId(String companyHrId) {
        return signingMapper.getStudentSigningByHrId(companyHrId);
    }

    @Override
    public List<StudentSigning> getStudentSigningByStudentId(String studentId) {
        return signingMapper.getStudentSigningByStudentId(studentId);
    }

    @Override
    public List<AdminEmploy> getStudentSigningByAdmin() {
        return signingMapper.getStudentSigningByAdmin();
    }
}
