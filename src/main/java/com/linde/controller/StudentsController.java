package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.linde.domain.Student.StudentOneResumes;
import com.linde.domain.Students;
import com.linde.service.impl.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
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

    /*
    @RequestParam String studentId,
                                     @RequestParam String studentName,
                                     @RequestParam String studentSex,
                                     @RequestParam Integer studentAge,
                                     @RequestParam  String studentEmail,
                                     @RequestParam  String studentTel,
                                     @RequestParam  String studentIdCards,
                                     @RequestParam  String studentDepartment,
                                     @RequestParam String  studentSubject,
                                     @RequestParam  Year studentEndYear,
                                     @RequestParam String password
     */
    @PostMapping("/insertStudentOne")
    public Result saveStudentOne(Students students) {
//        students.setDeleted(0);
//        students.setRole("student");
        boolean flag = studentsService.save(students);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }


    //admin端学生管理编辑
    @PutMapping("/admin/update")
    public Result updateStudentsInformationByAdmin(@RequestParam String studentId,
                                                   @RequestParam String studentName,
                                                   @RequestParam Integer studentAge,
                                                   @RequestParam String studentTel,
                                                   @RequestParam String studentDepartment,
                                                   @RequestParam String studentSubject,
                                                   @RequestParam Year studentEndYear,
                                                   @RequestParam Integer deleted
    ) {
//        LambdaUpdateWrapper<Students> studentsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//        studentsLambdaUpdateWrapper.eq(Students::getStudentId,studentId)
//                .set(Students::getStudentName,studentName)
//                .set(Students::getStudentAge,studentAge)
//                .set(Students::getStudentTel,studentTel)
//                .set(Students::getStudentDepartment,studentDepartment)
//                .set(Students::getStudentSubject,studentSubject)
//                .set(Students::getStudentEndYear,studentEndYear)
//                .set(Students::getDeleted,deleted);
        boolean flag = studentsService.updateStudentsInformationByAdmin(studentId, studentName, studentAge, studentTel, studentDepartment, studentSubject, studentEndYear, deleted);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }


    //admin端学生管理模糊查询
    @GetMapping("/studentName")
    public Result getStudentByStudentName(@RequestParam String studentName) {

        LambdaQueryWrapper<Students> studentsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        studentsLambdaQueryWrapper.like(Students::getStudentName, studentName);
        List<Students> students = studentsService.list(studentsLambdaQueryWrapper);
        Integer code = students != null ? Code.GET_OK : Code.GET_ERR;
        String msg = students != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, students, msg);
    }

    @PostMapping("/password")
    public Result updateStudentPasswordById(@RequestParam String studentId, @RequestParam String password) {
        LambdaUpdateWrapper<Students> studentsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        studentsLambdaUpdateWrapper.eq(Students::getStudentId, studentId)
                .set(Students::getPassword, password);
        boolean flag = studentsService.update(null, studentsLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_ERR : Code.UPDATE_ERR, flag);
    }

    @GetMapping("/studentId")
    public Result getStudentResumesByStudentId(@RequestParam String studentId) {
        StudentOneResumes studentResumesByStudentId = studentsService.getStudentResumesByStudentId(studentId);
        Integer code = studentResumesByStudentId != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentResumesByStudentId != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, studentResumesByStudentId, msg);
    }


    @PostMapping
    public Result saveStudentsInformation(@RequestBody Students students) {
        boolean flag = studentsService.save(students);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }


    @DeleteMapping("/{studentId}")
    public Result deleteStudentsInformation(@PathVariable String studentId) {
        boolean flag = studentsService.removeById(studentId);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{studentId}")
    public Result getStudentsInformationById(@PathVariable String studentId) {

        Students students = studentsService.getById(studentId);
        Integer code = students != null ? Code.GET_OK : Code.GET_ERR;
        String msg = students != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, students, msg);
    }

    @GetMapping
    public Result getStudentsInformationAll() {
        List<Students> studentsList = studentsService.getStudentsInformationAll();
        Integer code = studentsList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentsList != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, studentsList, msg);
    }


    @PutMapping("/update")
    public Result updateStudentsPasswordById(@RequestParam String studentId, @RequestParam String password) {
        boolean flag = studentsService.updateStudentsPasswordById(studentId, password);
        return new Result(flag ? Code.UPDATE_ERR : Code.UPDATE_ERR, flag);
    }

}

