package com.linde.controller;


import com.linde.domain.Hr.HrStudentInterview;
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

