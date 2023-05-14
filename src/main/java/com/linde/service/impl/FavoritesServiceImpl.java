package com.linde.service.impl;

import com.linde.domain.Favorites;
import com.linde.domain.Student.StudentFavorites;
import com.linde.mapper.FavoritesMapper;
import com.linde.service.IFavoritesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites> implements IFavoritesService {

    @Autowired
    private FavoritesMapper favoritesMapper;

    @Override
    public List<StudentFavorites> getStudentFavoriteByStudentId(String studentId) {
        return favoritesMapper.getStudentFavoriteByStudentId(studentId);
    }

    @Override
    public List<StudentFavorites> getStudentFavoriteLikeByStudent(String studentId, String positionName) {
        return favoritesMapper.getStudentFavoriteLikeByStudent(studentId, positionName);
    }


}
