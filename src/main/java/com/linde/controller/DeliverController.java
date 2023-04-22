package com.linde.controller;


import com.linde.domain.Hr.HrStudentDeliver;
import com.linde.domain.Student.StudentDeliver;
import com.linde.service.impl.DeliverServiceImpl;
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
@RequestMapping("/deliver")
@CrossOrigin
public class DeliverController {

    @Autowired
    private DeliverServiceImpl deliverService;

    @GetMapping("/hrDeliverStudent")
    public Result getStudentDeliver(@RequestParam String companyHrId){
        List<HrStudentDeliver> hrStudentDeliver = deliverService.getStudentDeliver(companyHrId);
        Integer code = hrStudentDeliver != null ? Code.GET_OK : Code.GET_ERR;
        String msg = hrStudentDeliver != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, hrStudentDeliver,msg);
    }

    @GetMapping("/studentDeliver")
    public Result getStudentDeliverByStudentId(@RequestParam String studentId){
        List<StudentDeliver> studentDeliverByStudentId = deliverService.getStudentDeliverByStudentId(studentId);
        Integer code = studentDeliverByStudentId != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentDeliverByStudentId != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code, studentDeliverByStudentId,msg);
    }
}

