package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.linde.domain.StudentResumes;
import com.linde.service.impl.StudentResumesServiceImpl;
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
@RequestMapping("/studentResumes")
public class StudentResumesController {

    @Autowired
    private StudentResumesServiceImpl studentResumesService;

    @PostMapping
    public Result saveStudentsResumesInformation(@RequestBody StudentResumes studentResumes){
        boolean flag = studentResumesService.save(studentResumes);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR , flag);
    }
    @PutMapping
    public Result updateStudentsResumesInformation(@RequestBody StudentResumes studentResumes){

        LambdaUpdateWrapper<StudentResumes> studentResumesLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        studentResumesLambdaUpdateWrapper.eq(StudentResumes::getStudentResumeId,studentResumes.getStudentResumeId())
                .set(StudentResumes::getResumeExperience,studentResumes.getResumeExperience())
                .set(StudentResumes::getResumeSkills,studentResumes.getResumeSkills())
                .set(StudentResumes::getResumeEvaluation,studentResumes.getResumeEvaluation())
                .set(StudentResumes::getResumeSalaryExpectation,studentResumes.getResumeSalaryExpectation());

        boolean flag = studentResumesService.update(studentResumes,studentResumesLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR , flag);
    }

    @GetMapping("/{studentResumeId}")
    public Result getStudentsResumesInformationById(@PathVariable Long studentResumeId){

        StudentResumes studentResumesServiceById = studentResumesService.getById(studentResumeId);
        Integer code = studentResumesServiceById != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentResumesServiceById != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,studentResumesServiceById,msg);
    }

}

