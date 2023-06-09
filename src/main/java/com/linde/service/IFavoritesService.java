package com.linde.service;

import com.linde.domain.Favorites;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linde.domain.Student.StudentFavorites;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Linde
 * @since 2023-04-17
 */
public interface IFavoritesService extends IService<Favorites> {
     List<StudentFavorites> getStudentFavoriteByStudentId(String studentId);

     List<StudentFavorites> getStudentFavoriteLikeByStudent(String studentId,String positionName);

}
