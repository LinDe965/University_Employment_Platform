package com.linde.controller;


import com.linde.domain.Student.StudentFavorites;
import com.linde.service.impl.FavoritesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/studentFavorites")
    public Result getStudentFavoriteByStudentId(@RequestParam String studentId){
        List<StudentFavorites> studentFavoriteByStudentId = favoritesService.getStudentFavoriteByStudentId(studentId);
        Integer code = studentFavoriteByStudentId != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentFavoriteByStudentId != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, studentFavoriteByStudentId,msg);
    }
}

