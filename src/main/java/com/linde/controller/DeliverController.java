package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.linde.domain.Deliver;
import com.linde.domain.Favorites;
import com.linde.domain.Hr.HrStudentDeliver;
import com.linde.domain.Position;
import com.linde.domain.Student.StudentDeliver;
import com.linde.domain.Students;
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

    @GetMapping("/student/like")
    public Result getStudentDeliverLikeByStudent(@RequestParam String studentId,@RequestParam String positionName){
        List<StudentDeliver> studentDeliverLikeByStudent = deliverService.getStudentDeliverLikeByStudent(studentId, positionName);
        Integer code = studentDeliverLikeByStudent != null ? Code.GET_OK : Code.GET_ERR;
        String msg = studentDeliverLikeByStudent != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,studentDeliverLikeByStudent,msg);
    }
    @GetMapping("/hr/like")
    public Result getPositionLikeByHr(@RequestParam String companyHrId,@RequestParam String studentName){
        List<HrStudentDeliver> positionLikeByHr = deliverService.getPositionLikeByHr(companyHrId,studentName);
        Integer code = positionLikeByHr != null ? Code.GET_OK : Code.GET_ERR;
        String msg = positionLikeByHr != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,positionLikeByHr,msg);
    }


    //hr端更新用户投递状态
    @PutMapping("/updateStatusByHr")
    public Result updateStudentDeliverStatusByHr(@RequestParam String deliverId,@RequestParam Integer deliverStatus){
        LambdaUpdateWrapper<Deliver> deliverLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        deliverLambdaUpdateWrapper.eq(Deliver::getDeliverId,deliverId).set(Deliver::getDeliverStatus,deliverStatus);
        boolean flag = deliverService.update(deliverLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    //学生前台投递接口
    @GetMapping("/insertDeliver")
    public Result saveStudentDeliverByPositionId(@RequestParam String studentId,@RequestParam String positionId){
        Deliver deliver = new Deliver();
        deliver.setStudentId(studentId);
        deliver.setPositionId(positionId);
        boolean flag = deliverService.save(deliver);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

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

