package com.linde.service.impl;

import com.linde.domain.StudentDetail;
import com.linde.mapper.StudentDetailMapper;
import com.linde.service.IStudentDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Linde
 * @since 2023-03-29
 */
@Service
public class StudentDetailServiceImpl extends ServiceImpl<StudentDetailMapper, StudentDetail> implements IStudentDetailService {

}
