package com.linde.service;

import com.linde.domain.Deliver;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linde.domain.Hr.HrStudentDeliver;
import com.linde.domain.Student.StudentDeliver;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Linde
 * @since 2023-04-17
 */
public interface IDeliverService extends IService<Deliver> {
    public List<HrStudentDeliver> getStudentDeliver(String companyHrId);

    public List<StudentDeliver> getStudentDeliverByStudentId(String studentId);
    List<HrStudentDeliver> getPositionLikeByHr(String companyHrId,String studentName);

    List<StudentDeliver> getStudentDeliverLikeByStudent(String studentId,String positionName);

}
