package com.linde.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.linde.domain.Admin.AdminEmploy;
import com.linde.domain.Hr.HrStudentResumes;
import com.linde.domain.Hr.HrStudentSigning;
import com.linde.domain.Student.StudentSigning;
import com.linde.service.impl.SigningServiceImpl;
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
@RequestMapping("/signing")
@CrossOrigin
public class SigningController {
    @Autowired
    private SigningServiceImpl signingService;

    @GetMapping("/hrSigningStudent")
    public Result getStudentSigningByHrId(@RequestParam String companyHrId){
        List<HrStudentSigning> studentSigningByHrId = signingService.getStudentSigningByHrId(companyHrId);
        Integer code = studentSigningByHrId != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentSigningByHrId != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, studentSigningByHrId,msg);
    }

    @GetMapping("/studentSigning")
    public Result getStudentSigningByStudentId(@RequestParam String studentId){
        List<StudentSigning> studentSigningByStudentId = signingService.getStudentSigningByStudentId(studentId);
        Integer code = studentSigningByStudentId != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentSigningByStudentId != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, studentSigningByStudentId,msg);
    }

    @GetMapping("/adminEmploy")
    public Result getStudentSigningByAdmin(){
        List<AdminEmploy> studentSigningByAdmin = signingService.getStudentSigningByAdmin();
        Integer code = studentSigningByAdmin != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentSigningByAdmin != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, studentSigningByAdmin,msg);
    }
}

