package com.linde.controller;


import com.linde.domain.Post;
import com.linde.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Linde
 * @since 2023-04-02
 */
@RestController
@CrossOrigin
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @PostMapping
    public Result savePostInformation(@RequestBody Post post){
        boolean flag = postService.save(post);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @DeleteMapping("/{postId}")
    public Result deletePostInformation(@PathVariable String postId){
        boolean flag = postService.removeById(postId);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping
    public Result getPostInformationAll(){
        List<Post> postList = postService.list();
        Integer code = postList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = postList != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,postList,msg);
    }




}

