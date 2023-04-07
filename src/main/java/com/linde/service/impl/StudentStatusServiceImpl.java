package com.linde.service.impl;

import com.linde.domain.StudentStatus;
import com.linde.mapper.StudentStatusMapper;
import com.linde.service.IStudentStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Linde
 * @since 2023-04-05
 */
@Service
public class StudentStatusServiceImpl extends ServiceImpl<StudentStatusMapper, StudentStatus> implements IStudentStatusService {

}
