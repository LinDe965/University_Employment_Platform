package com.linde.service.impl;

import com.linde.domain.StudentFavorites;
import com.linde.mapper.StudentFavoritesMapper;
import com.linde.service.IStudentFavoritesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Linde
 * @since 2023-04-02
 */
@Service
public class StudentFavoritesServiceImpl extends ServiceImpl<StudentFavoritesMapper, StudentFavorites> implements IStudentFavoritesService {

}
