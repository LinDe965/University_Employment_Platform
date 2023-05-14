package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.linde.domain.Admin.AdminEmploy;
import com.linde.domain.Hr.HrStudentInterview;
import com.linde.domain.Hr.HrStudentResumes;
import com.linde.domain.Hr.HrStudentSigning;
import com.linde.domain.Interview;
import com.linde.domain.Signing;
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


    @GetMapping("/admin/like")
    public Result getStudentSigningLikeByAdmin(@RequestParam String studentName){
        List<AdminEmploy> studentSigningLikeByAdmin = signingService.getStudentSigningLikeByAdmin(studentName);
        Integer code = studentSigningLikeByAdmin != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentSigningLikeByAdmin != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,studentSigningLikeByAdmin,msg);
    }

    //stu端签约模糊搜索
    @GetMapping("/student/like")
    public Result getStudentSigningLikeByStudent(@RequestParam String studentId,@RequestParam String positionName) {
        List<StudentSigning> studentSigningLikeByStudent = signingService.getStudentSigningLikeByStudent(studentId, positionName);
        Integer code = studentSigningLikeByStudent != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentSigningLikeByStudent != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,studentSigningLikeByStudent,msg);
    }

    //hr端签约管理模糊搜索
    @GetMapping("/hr/like")
    public Result getStudentSigningLikeByHr(@RequestParam String companyHrId,@RequestParam String studentName){
        List<HrStudentSigning> studentSigningLikeByHr = signingService.getStudentSigningLikeByHr(companyHrId, studentName);
        Integer code = studentSigningLikeByHr != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentSigningLikeByHr != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,studentSigningLikeByHr,msg);
    }

    //stu端更新签约状态
    @PutMapping("/updateSigningStudentStatusByStudent")
    public Result updateSigningStudentStatusByStudent(@RequestParam String signingId,@RequestParam Integer signingStudentStatus){
        LambdaUpdateWrapper<Signing> signingLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        signingLambdaUpdateWrapper.eq(Signing::getSigningId,signingId)
                .set(Signing::getSigningStudentStatus,signingStudentStatus);
        boolean flag = signingService.update(signingLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    //hr端添加面试
    @GetMapping("/insertSigning")
    public Result saveStudentSigningByHr(@RequestParam String companyHrId,@RequestParam String studentName,
                                         @RequestParam String positionName,@RequestParam String signingAddress){
        boolean flag = signingService.saveStudentSigningByHr(companyHrId,studentName,positionName,signingAddress);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }


    //hr端修改hr是否录用状态
    @PutMapping("/updateSigningStatusByHr")
    public Result updateStudentSigningStatusByHr(@RequestParam String signingId,@RequestParam Integer signingStatus){
        LambdaUpdateWrapper<Signing> signingLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        signingLambdaUpdateWrapper.eq(Signing::getSigningId,signingId).set(Signing::getSigningStatus,signingStatus);
        boolean flag = signingService.update(signingLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

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

