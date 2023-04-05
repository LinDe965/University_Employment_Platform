package com.linde.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.linde.domain.Admins;
import com.linde.domain.Students;
import com.linde.mapper.StudentsMapper;
import com.linde.service.IStudentsService;
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
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements IStudentsService {


    @Autowired
    private StudentsMapper studentsMapper;

    @Override
    public boolean updateStudentsPasswordById(String studentId,String password) {
        Students students = new Students();
        students.setStudentId(studentId);
        students.setPassword(password);
        return studentsMapper.updateById(students) > 0;
    }
}
