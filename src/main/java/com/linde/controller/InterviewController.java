package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.linde.domain.Deliver;
import com.linde.domain.Hr.HrStudentInterview;
import com.linde.domain.Interview;
import com.linde.domain.Student.StudentInterview;
import com.linde.service.impl.InterviewServiceImpl;
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
@RequestMapping("/interview")
@CrossOrigin
public class InterviewController {

    @Autowired
    private InterviewServiceImpl interviewService;

    @GetMapping("/student/like")
    public Result getStudentInterviewLikeByStudent(@RequestParam String studentId,@RequestParam String positionName){
        List<StudentInterview> studentInterviewLikeByStudent = interviewService.getStudentInterviewLikeByStudent(studentId, positionName);
        Integer code = studentInterviewLikeByStudent != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentInterviewLikeByStudent != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,studentInterviewLikeByStudent,msg);
    }

    //hr端面试管理模糊搜索
    @GetMapping("/hr/like")
    public Result getStudentInterviewLikeByHr(@RequestParam String companyHrId,@RequestParam String studentName){
        List<HrStudentInterview> studentInterviewLikeByHr = interviewService.getStudentInterviewLikeByHr(companyHrId, studentName);
        Integer code = studentInterviewLikeByHr != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentInterviewLikeByHr != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,studentInterviewLikeByHr,msg);
    }

    //stu端更新面试状态
    @PutMapping("/updateInterviewStudentStatusByStudent")
    public Result updateInterviewStudentStatusByStudent(@RequestParam String interviewId,@RequestParam Integer interviewStudentStatus){
        LambdaUpdateWrapper<Interview> interviewLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        interviewLambdaUpdateWrapper.eq(Interview::getInterviewId,interviewId)
                .set(Interview::getInterviewStudentStatus,interviewStudentStatus);
        boolean flag = interviewService.update(interviewLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    //hr端添加面试
    @GetMapping("/insertInterview")
    public Result saveStudentInterviewByHr(@RequestParam String companyHrId,@RequestParam String studentName,
                                           @RequestParam String positionName,@RequestParam String interviewAddress){
        boolean flag = interviewService.saveStudentInterviewByHr(companyHrId,studentName,positionName,interviewAddress);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }


    //hr端修改hr是否通过面试状态
    @PutMapping("/updateInterviewStatusByHr")
    public Result updateStudentInterviewStatusByHr(@RequestParam String interviewId,@RequestParam Integer interviewStatus){
        LambdaUpdateWrapper<Interview> interviewLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        interviewLambdaUpdateWrapper.eq(Interview::getInterviewId,interviewId).set(Interview::getInterviewStatus,interviewStatus);
        boolean flag = interviewService.update(interviewLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @GetMapping("/hrInterviewStudent")
    public Result getStudentInterviewByHrId(@RequestParam String companyHrId){
        List<HrStudentInterview> studentInterviewByHrId = interviewService.getStudentInterviewByHrId(companyHrId);
        Integer code = studentInterviewByHrId != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentInterviewByHrId != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, studentInterviewByHrId,msg);
    }

    @GetMapping("/studentInterview")
    public Result getStudentInterviewByStudentId(@RequestParam String studentId){
        List<StudentInterview> studentInterviewByStudentId = interviewService.getStudentInterviewByStudentId(studentId);
        Integer code = studentInterviewByStudentId != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentInterviewByStudentId != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, studentInterviewByStudentId,msg);
    }
}

