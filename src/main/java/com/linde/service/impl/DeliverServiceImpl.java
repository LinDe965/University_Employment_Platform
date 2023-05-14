package com.linde.service.impl;

import com.linde.domain.Deliver;
import com.linde.domain.Hr.HrStudentDeliver;
import com.linde.domain.Student.StudentDeliver;
import com.linde.mapper.DeliverMapper;
import com.linde.service.IDeliverService;
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
public class DeliverServiceImpl extends ServiceImpl<DeliverMapper, Deliver> implements IDeliverService {

    @Autowired
    private DeliverMapper deliverMapper;

    @Override
    public List<HrStudentDeliver> getStudentDeliver(String companyHrId) {
        return deliverMapper.getStudentDeliver(companyHrId);
    }

    @Override
    public List<StudentDeliver> getStudentDeliverByStudentId(String studentId) {
        return deliverMapper.getStudentDeliverByStudentId(studentId);
    }

    @Override
    public List<HrStudentDeliver> getPositionLikeByHr(String companyHrId,String studentName) {
        return deliverMapper.getPositionLikeByHr(companyHrId,studentName);
    }

    @Override
    public List<StudentDeliver> getStudentDeliverLikeByStudent(String studentId, String positionName) {
        return deliverMapper.getStudentDeliverLikeByStudent(studentId, positionName);
    }
}
