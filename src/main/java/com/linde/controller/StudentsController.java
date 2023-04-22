package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.linde.domain.Student.StudentOneResumes;
import com.linde.domain.Students;
import com.linde.service.impl.StudentsServiceImpl;
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
@RequestMapping("/api/students")
public class StudentsController {

    @Autowired
    private StudentsServiceImpl studentsService;

    @PostMapping("/password")
    public Result updateStudentPasswordById(@RequestParam String studentId,@RequestParam String password){
        LambdaUpdateWrapper<Students> studentsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        studentsLambdaUpdateWrapper.eq(Students::getStudentId,studentId)
                .set(Students::getPassword,password);
        boolean flag = studentsService.update(null, studentsLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_ERR:Code.UPDATE_ERR,flag);
    }

    @GetMapping("/studentId")
    public Result getStudentResumesByStudentId(@RequestParam String studentId){
        StudentOneResumes studentResumesByStudentId = studentsService.getStudentResumesByStudentId(studentId);
        Integer code = studentResumesByStudentId != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentResumesByStudentId != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, studentResumesByStudentId,msg);
    }

    @PostMapping
    public Result saveStudentsInformation(@RequestBody Students students){
        boolean flag = studentsService.save(students);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result updateStudentsInformation(@RequestBody Students students){
        LambdaUpdateWrapper<Students> studentsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        studentsLambdaUpdateWrapper.eq(Students::getStudentId,students.getStudentId())
                .set(Students::getStudentName,students.getStudentName())
                .set(Students::getStudentAge,students.getStudentAge())
                .set(Students::getStudentTel,students.getStudentTel())
                .set(Students::getStudentEmail,students.getStudentEmail())
                .set(Students::getStudentIdCards,students.getStudentIdCards())
                .set(Students::getStudentDepartment,students.getStudentDepartment())
                .set(Students::getStudentSubject,students.getStudentSubject())
                .set(Students::getStudentEndYear,students.getStudentEndYear());
        boolean flag = studentsService.update(students,studentsLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_ERR:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{studentId}")
    public Result deleteStudentsInformation(@PathVariable String studentId){
        boolean flag =  studentsService.removeById(studentId);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{studentId}")
    public Result getStudentsInformationById(@PathVariable String studentId){

        Students students =  studentsService.getById(studentId);
        Integer code = students != null ? Code.GET_OK : Code.GET_ERR;
        String msg = students != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,students,msg);
    }

    @GetMapping
    public Result getStudentsInformationAll(){

        List<Students> studentsList = studentsService.list();
        Integer code = studentsList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentsList != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,studentsList,msg);
    }


    @PutMapping("/update")
    public Result updateStudentsPasswordById(@RequestParam String studentId,@RequestParam String password){
        boolean flag = studentsService.updateStudentsPasswordById(studentId,password);
        return new Result(flag ? Code.UPDATE_ERR:Code.UPDATE_ERR,flag);
    }

}

