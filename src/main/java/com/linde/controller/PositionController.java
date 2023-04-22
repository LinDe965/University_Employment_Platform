package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.linde.domain.Admin.AdminPosition;
import com.linde.domain.Position;
import com.linde.service.impl.CompanyHrServiceImpl;
import com.linde.service.impl.CompanyServiceImpl;
import com.linde.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionServiceImpl positionService;

    @GetMapping("/admin")
    public Result getPositionByAdmin(){
        List<AdminPosition> positionByAdmin = positionService.getPositionByAdmin();
        Integer code = positionByAdmin != null ? Code.GET_OK : Code.GET_ERR;
        String msg = positionByAdmin != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,positionByAdmin,msg);
    }

    @GetMapping("/getByHrId")
    public Result getByHrIdPositionInformation(@RequestParam String companyHrId){
        List<Position> positionList = positionService.getByHrIdPositionInformation(companyHrId);
        Integer code = positionList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = positionList != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,positionList,msg);
    }


    @PostMapping
    public Result savePostInformation(@RequestBody Position position){
        boolean flag = positionService.save(position);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR ,flag);
    }

    @PutMapping
    public Result updatePostInformation(@RequestBody Position position){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleDateFormat.format(System.currentTimeMillis());

        LambdaUpdateWrapper<Position> positionLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        positionLambdaUpdateWrapper.eq(Position::getPositionId,position.getPositionId())
                //.eq(Position::getCompanyHrId,position.getCompanyHrId())
                .set(Position::getPositionName,position.getPositionName())
                .set(Position::getPositionRecruitNumber,position.getPositionRecruitNumber())
                .set(Position::getPositionSalary,position.getPositionSalary())
                .set(Position::getPositionRequire,position.getPositionRequire())
                .set(Position::getPositionUpdateTime,now);

        boolean flag = positionService.update(position, positionLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_ERR:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{positionId}")
    public Result deletePostInformation(@PathVariable String positionId){
        boolean flag = positionService.removeById(positionId);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{companyHrId}")
    public Result getPostInformationByCompanyHrId(@PathVariable Long companyHrId){

        Position positionServiceById = positionService.getById(companyHrId);
        Integer code = positionServiceById != null ? Code.GET_OK : Code.GET_ERR;
        String msg = positionServiceById != null ? "数据查询成功!" : "数据查询失败,请重试!";

        return new Result(code,positionServiceById,msg);
    }




}

