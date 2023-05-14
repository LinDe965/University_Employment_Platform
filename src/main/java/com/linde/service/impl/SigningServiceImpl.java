package com.linde.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linde.domain.Admin.AdminEmploy;
import com.linde.domain.Hr.HrStudentSigning;
import com.linde.domain.Position;
import com.linde.domain.Signing;
import com.linde.domain.Student.StudentInterview;
import com.linde.domain.Student.StudentSigning;
import com.linde.domain.Students;
import com.linde.mapper.PositionMapper;
import com.linde.mapper.SigningMapper;
import com.linde.mapper.StudentsMapper;
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

    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private PositionMapper positionMapper;

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

    @Override
    public boolean saveStudentSigningByHr(String companyHrId,String studentName,String positionName,String signingAddress) {
        Signing signing = new Signing();
        signing.setSigningAddress(signingAddress);

        // 通过student_name查询student_id
        QueryWrapper<Students> studentsQueryWrapper = new QueryWrapper<>();
        studentsQueryWrapper.eq("student_name",studentName);
        Students students = studentsMapper.selectOne(studentsQueryWrapper);
        if (students == null){
            throw new RuntimeException("学生不存在");
        }
        signing.setStudentId(students.getStudentId());

        // 通过position_name查询position_id
        QueryWrapper<Position> positionQueryWrapper = new QueryWrapper<>();
        positionQueryWrapper.eq("position_name",positionName);
        Position position = positionMapper.selectOne(positionQueryWrapper);
        if (position == null){
            throw new RuntimeException("职位不存在");
        }
        if(!position.getCompanyHrId().equals(companyHrId)){
            throw new RuntimeException("HR身份验证失败");
        }
        signing.setPositionId(position.getPositionId());

        return signingMapper.insert(signing) > 0;
    }


    //hr端签约管理模糊搜索
    @Override
    public List<HrStudentSigning> getStudentSigningLikeByHr(String companyHrId, String studentName) {
        return signingMapper.getStudentSigningLikeByHr(companyHrId, studentName);
    }

    @Override
    public List<StudentSigning> getStudentSigningLikeByStudent(String studentId, String positionName) {
        return signingMapper.getStudentSigningLikeByStudent(studentId, positionName);
    }

    @Override
    public List<AdminEmploy> getStudentSigningLikeByAdmin(String studentName) {
        return signingMapper.getStudentSigningLikeByAdmin(studentName);
    }
}
