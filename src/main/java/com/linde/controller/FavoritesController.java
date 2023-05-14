package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.linde.domain.Favorites;
import com.linde.domain.Student.StudentFavorites;
import com.linde.service.impl.FavoritesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Linde
 * @since 2023-04-17
 */
@RestController
@RequestMapping("/favorites")
@CrossOrigin
public class FavoritesController {

    @Autowired
    private FavoritesServiceImpl favoritesService;


    @GetMapping("/student/like")
    public Result getStudentFavoriteLikeByStudent(@RequestParam String studentId,@RequestParam String positionName){
        List<StudentFavorites> studentFavoriteLikeByStudent = favoritesService.getStudentFavoriteLikeByStudent(studentId, positionName);
        Integer code = studentFavoriteLikeByStudent != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentFavoriteLikeByStudent != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,studentFavoriteLikeByStudent,msg);
    }

    //stu端收藏状态切换
    @PutMapping("/updateStatusByHr")
    public Result updateFavoriteStatusByStudent(@RequestParam String favoritesId,@RequestParam Integer favoritesStatus){
        LambdaUpdateWrapper<Favorites> favoritesLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        favoritesLambdaUpdateWrapper.eq(Favorites::getFavoritesId,favoritesId)
                .set(Favorites::getFavoritesStatus,favoritesStatus);
        boolean flag = favoritesService.update(favoritesLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @GetMapping("/studentFavorites")
    public Result getStudentFavoriteByStudentId(@RequestParam String studentId){
        List<StudentFavorites> studentFavoriteByStudentId = favoritesService.getStudentFavoriteByStudentId(studentId);
        Integer code = studentFavoriteByStudentId != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentFavoriteByStudentId != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, studentFavoriteByStudentId,msg);
    }

    @GetMapping("/insertFavorites")
    public Result saveStudentFavoriteByPositionId(@RequestParam String studentId,@RequestParam String positionId){
        Favorites favorites = new Favorites();
        favorites.setStudentId(studentId);
        favorites.setPositionId(positionId);
        //favorites.setStudentFavoritesTime(LocalDateTime.now());
        boolean flag = favoritesService.save(favorites);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

}

