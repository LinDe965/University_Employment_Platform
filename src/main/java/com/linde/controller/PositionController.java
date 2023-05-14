package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.linde.domain.Admin.AdminPosition;
import com.linde.domain.Pos.PositionDetail;
import com.linde.domain.Pos.PositionNews;
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

    //admin端职位状态切换
    @PutMapping("/admin/enable")
    public Result updatePositionEnableByAdmin(@RequestParam String positionId,@RequestParam Integer enable){
        LambdaUpdateWrapper<Position> positionLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        positionLambdaUpdateWrapper.eq(Position::getPositionId,positionId)
                .set(Position::getEnable,enable);
        boolean flag = positionService.update(positionLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    //admin端职位模糊搜索
    @GetMapping("/admin/like")
    public Result getPositionLikeByAdmin(@RequestParam String positionName){
        List<AdminPosition> positionLikeByAdmin = positionService.getPositionLikeByAdmin(positionName);
        Integer code = positionLikeByAdmin != null ? Code.GET_OK : Code.GET_ERR;
        String msg = positionLikeByAdmin != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,positionLikeByAdmin,msg);
    }

    @GetMapping("/hr/like")
    public Result getPositionLikeByHr(@RequestParam String positionName){
        LambdaQueryWrapper<Position> positionLambdaQueryWrapper = new LambdaQueryWrapper<>();
        positionLambdaQueryWrapper.like(Position::getPositionName,positionName);
        List<Position> positionList = positionService.list(positionLambdaQueryWrapper);
        Integer code = positionList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = positionList != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,positionList,msg);
    }

    //hr端招聘信息删除
    @DeleteMapping("/deletePositionByCompanyHr")
    public Result deletePositionByCompanyHr(@RequestParam String positionId){
        boolean flag = positionService.removeById(positionId);
        return  new Result(flag? Code.DELETE_OK : Code.UPDATE_ERR , flag);
    }


    //hr端招聘信息修改
    @PutMapping("/updatePositionByCompanyHr")
    public Result updatePositionByCompanyHr(@RequestParam String positionId,
                                            @RequestParam String positionName,
                                            @RequestParam Integer positionRecruitNumber,
                                            @RequestParam Integer positionSalary,
                                            @RequestParam String positionRequire){
        LambdaUpdateWrapper<Position> positionLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        positionLambdaUpdateWrapper.eq(Position::getPositionId,positionId)
                .set(Position::getPositionName,positionName)
                .set(Position::getPositionRecruitNumber,positionRecruitNumber)
                .set(Position::getPositionSalary,positionSalary)
                .set(Position::getPositionRequire,positionRequire);
        boolean flag = positionService.update(positionLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    //hr端招聘信息添加
    @GetMapping("/savePositionByCompanyHr")
    public Result savePositionByCompanyHr(@RequestParam String companyHrId,
                                          @RequestParam String positionName,
                                          @RequestParam Integer positionRecruitNumber,
                                          @RequestParam Integer positionSalary,
                                          @RequestParam String positionRequire){
        Position position = new Position();
        position.setCompanyHrId(companyHrId);
        position.setPositionName(positionName);
        position.setPositionRecruitNumber(positionRecruitNumber);
        position.setPositionSalary(positionSalary);
        position.setPositionRequire(positionRequire);
        boolean flag = positionService.save(position);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    //招聘信息详情接口
    @GetMapping("/posDetail")
    public  Result getFrontPositionDetailInformation(@RequestParam String positionId){
        PositionDetail frontPositionDetailInformation = positionService.getFrontPositionDetailInformation(positionId);
        Integer code = frontPositionDetailInformation != null ? Code.GET_OK : Code.GET_ERR;
        String msg = frontPositionDetailInformation != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,frontPositionDetailInformation,msg);
    }

    //招聘信息列表接口
    @GetMapping("/posList")
    public  Result getPositionNewsDetail(){
        List<PositionNews> positionNewsDetail = positionService.getFrontPositionDetail();
        Integer code = positionNewsDetail != null ? Code.GET_OK : Code.GET_ERR;
        String msg = positionNewsDetail != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,positionNewsDetail,msg);
    }


    @GetMapping("/admin")
    public Result getPositionByAdmin(){
        List<AdminPosition> positionByAdmin = positionService.getPositionByAdmin();
        Integer code = positionByAdmin != null ? Code.GET_OK : Code.GET_ERR;
        String msg = positionByAdmin != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,positionByAdmin,msg);
    }

    //hr端职位管理获取全部数据
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
                ;

        boolean flag = positionService.update(position, positionLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
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

