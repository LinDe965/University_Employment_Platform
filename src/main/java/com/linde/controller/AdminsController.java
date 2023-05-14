package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.linde.domain.Admins;
import com.linde.domain.Students;
import com.linde.service.impl.AdminsServiceImpl;
import com.linde.service.impl.StudentsServiceImpl;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api/admins")
public class AdminsController {
    @Autowired
    private AdminsServiceImpl adminsService;


    //Admin端个人信息获取
    @GetMapping("/getOne")
    public Result getAdminDetailByAdminId(@RequestParam String adminId){
        Admins admins = adminsService.getById(adminId);
        Integer code = admins != null ? Code.GET_OK : Code.GET_ERR;
        String msg = admins != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,admins,msg);
    }

    @PostMapping("/password")
    public Result updateAdminsPasswordById(@RequestParam String adminId,@RequestParam String password){
        LambdaUpdateWrapper<Admins> adminsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        adminsLambdaUpdateWrapper.eq(Admins::getAdminId,adminId)
                .set(Admins::getPassword,password);
        boolean flag = adminsService.update(null, adminsLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_ERR:Code.UPDATE_ERR,flag);
    }

    //个人中心
    @GetMapping("/{adminId}")
    public Result getAdminsById(@PathVariable String adminId){
        Admins admins = adminsService.getById(adminId);
        Integer code = admins != null ? Code.GET_OK : Code.GET_ERR;
        String msg = admins != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,admins,msg);
    }

    @PutMapping
    public Result updateAdminsAll(@RequestBody Admins admins){
        boolean flag = adminsService.updateAdminsDetailsAll(admins);
        return new Result(flag ? Code.UPDATE_ERR:Code.UPDATE_ERR,flag);
    }


}

