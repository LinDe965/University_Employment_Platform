package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.linde.domain.Company;
import com.linde.domain.CompanyHr;
import com.linde.service.impl.CompanyHrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Linde
 * @since 2023-04-03
 */
@RestController
@CrossOrigin
@RequestMapping("/companyHr")
public class CompanyHrController {
    @Autowired
    private CompanyHrServiceImpl companyHrService;

    @PostMapping
    public Result saveCompanyHrInformation(@RequestBody CompanyHr companyHr){
        boolean flag = companyHrService.save(companyHr);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result updateCompanyHrInformation(@RequestBody CompanyHr companyHr){
        LambdaUpdateWrapper<CompanyHr> companyHrLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        companyHrLambdaUpdateWrapper.eq(CompanyHr::getCompanyHrId,companyHr.getCompanyHrId())
                .set(CompanyHr::getCompanyHrName,companyHr.getCompanyHrName())
                .set(CompanyHr::getCompanyHrTel,companyHr.getCompanyHrTel())
                .set(CompanyHr::getCompanyHrEmail,companyHr.getCompanyHrEmail());
        boolean flag = companyHrService.update(companyHr,companyHrLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_ERR:Code.UPDATE_ERR,flag);
    }

    @PutMapping("/update")
    public Result updateCompanyHrPasswordById(@RequestParam Long companyHrId,@RequestParam String password){
        boolean flag = companyHrService.updateCompanyHrPasswordById(companyHrId,password);
        return new Result(flag ? Code.UPDATE_ERR:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{companyHrId}")
    public Result deleteCompanyHrInformation(@PathVariable Long companyHrId){
        boolean flag = companyHrService.removeById(companyHrId);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{companyHrId}")
    public Result getCompanyHrInformationByName(@PathVariable Long companyHrId){
        CompanyHr companyHr = companyHrService.getById(companyHrId);
        Integer code = companyHr != null ? Code.GET_OK : Code.GET_ERR;
        String msg = companyHr != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,companyHr,msg);
    }

    @GetMapping
    public Result getCompanyHrInformationAll(){
        List<CompanyHr> companyHrList = companyHrService.list();
        Integer code = companyHrList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = companyHrList != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,companyHrList,msg);
    }
}

