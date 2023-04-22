package com.linde.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.linde.domain.Company;
import com.linde.service.impl.CompanyServiceImpl;
import org.apache.catalina.User;
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
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyServiceImpl companyService;

    @GetMapping
    public Result getCompanyAllByAdmin(){
        List<Company> companyList = companyService.list();
        Integer code = companyList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = companyList != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,companyList,msg);
    }

    @PostMapping
    public Result saveCompanyInformation(@RequestBody Company company){
        boolean flag = companyService.save(company);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result updateCompanyInformation(@RequestBody Company company){
        LambdaUpdateWrapper<Company> companyLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        companyLambdaUpdateWrapper.eq(Company::getCompanyId,company.getCompanyId())
                .set(Company::getCompanyName,company.getCompanyName())
                .set(Company::getCompanyAddress,company.getCompanyAddress())
                .set(Company::getCompanyIndustry,company.getCompanyIndustry())
                .set(Company::getCompanyIntroduction,company.getCompanyIntroduction())
                .set(Company::getCompanyDetail,company.getCompanyDetail());
        boolean flag = companyService.update(company,companyLambdaUpdateWrapper);
        return new Result(flag ? Code.UPDATE_ERR:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{companyId}")
    public Result deleteCompanyInformation(@PathVariable String companyId){
        boolean flag = companyService.removeById(companyId);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{companyName}")
    public Result getCompanyInformationByName(@PathVariable String companyName){
        LambdaQueryWrapper<Company> companyLambdaQueryWrapper = new LambdaQueryWrapper<>();

        //根据名字模糊查询
        companyLambdaQueryWrapper.like(Company::getCompanyName,companyName);

        Company company = companyService.getOne(companyLambdaQueryWrapper);
        Integer code = company != null ? Code.GET_OK : Code.GET_ERR;
        String msg = company != null ? "数据查询成功!" : "数据查询失败,请重试!";
        return new Result(code,company,msg);
    }


}

