package com.linde.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linde.domain.Hr.HrStudentInterview;
import com.linde.domain.Interview;
import com.linde.domain.Position;
import com.linde.domain.Student.StudentInterview;
import com.linde.domain.Students;
import com.linde.mapper.InterviewMapper;
import com.linde.mapper.PositionMapper;
import com.linde.mapper.StudentsMapper;
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

    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public List<HrStudentInterview> getStudentInterviewByHrId(String companyHrId) {
        return interviewMapper.getStudentInterviewByHrId(companyHrId);
    }

    @Override
    public List<StudentInterview> getStudentInterviewByStudentId(String studentId) {
        return interviewMapper.getStudentInterviewByStudentId(studentId);
    }

    @Override
    public boolean saveStudentInterviewByHr(String companyHrId,String studentName,String positionName,String interviewAddress) {
        Interview interview = new Interview();
        interview.setInterviewAddress(interviewAddress);
        // 通过student_name查询student_id
        QueryWrapper<Students> studentsQueryWrapper = new QueryWrapper<>();
        studentsQueryWrapper.eq("student_name",studentName);
        Students students = studentsMapper.selectOne(studentsQueryWrapper);
        if (students == null){
            throw new RuntimeException("学生不存在");
        }
        interview.setStudentId(students.getStudentId());

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

        interview.setPositionId(position.getPositionId());

        return interviewMapper.insert(interview) > 0;
    }


    //hr端面试管理模糊搜索
    @Override
    public List<HrStudentInterview> getStudentInterviewLikeByHr(String companyHrId, String studentName) {
        return interviewMapper.getStudentInterviewLikeByHr(companyHrId,studentName);
    }

    @Override
    public List<StudentInterview> getStudentInterviewLikeByStudent(String studentId, String positionName) {
        return interviewMapper.getStudentInterviewLikeByStudent(studentId, positionName);
    }


}
