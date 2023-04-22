package com.linde.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linde.domain.Admins;
import com.linde.domain.CompanyHr;
import com.linde.domain.Students;
import com.linde.service.impl.AdminsServiceImpl;
import com.linde.service.impl.CompanyHrServiceImpl;
import com.linde.service.impl.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthController {

    @Autowired
    private AdminsServiceImpl adminsService;

    @Autowired
    private CompanyHrServiceImpl companyHrService;

    @Autowired
    private StudentsServiceImpl studentsService;

    @PostMapping("/login")
    public Result login(@RequestParam String email, @RequestParam String password, @RequestParam String role) {
        if (role.equals("admin")) {
            Admins admins = adminsService.getOne(new QueryWrapper<Admins>()
                    .eq("admin_email", email)
                    .eq("role", role));
            //System.out.println(admins);

            Integer code = admins != null ? Code.GET_OK : Code.GET_ERR;
            String msg = admins != null ? "数据查询成功!" : "数据查询失败,请重试!";

            if (admins == null) {
                return new Result(code, null,msg); // 用户不存在或角色不匹配
            }

            if (password.equals(admins.getPassword())) {
                return new Result(code,admins,msg);// 密码匹配，返回用户对象
            }
        }

        else if (role.equals("hr")) {
            // 从数据库中通过邮箱查找用户
            CompanyHr companyHr = companyHrService.getOne(new QueryWrapper<CompanyHr>()
                    .eq("company_hr_email", email)
                    .eq("role", role));

            Integer code = companyHr != null ? Code.GET_OK : Code.GET_ERR;
            String msg = companyHr != null ? "数据查询成功!" : "数据查询失败,请重试!";

            if (companyHr == null) {
                return new Result(code, null,msg); // 用户不存在或角色不匹配
            }

            if (password.equals(companyHr.getPassword())) {
                return new Result(code, companyHr,msg); // 密码匹配，返回用户对象
            }
        }

        else if (role.equals("student")) {
            Students student = studentsService.getOne(new QueryWrapper<Students>()
                    .eq("student_email", email)
                    .eq("role", role));

            Integer code = student != null ? Code.GET_OK : Code.GET_ERR;
            String msg = student != null ? "数据查询成功!" : "数据查询失败,请重试!";

            if (student == null) {
                return new Result(code, null,msg); // 用户不存在或角色不匹配
            }

            if (password.equals(student.getPassword())) {
                return new Result(code, student,msg);// 密码匹配，返回用户对象
            }
        }
        return new Result(null,null,null);
    }

    @PostMapping("/cookie/companyHrId")
    public String getCookieCompanyHrId(String companyHrId){
        System.out.println("companyHrId:"+companyHrId);
        return companyHrId;
    }

    @PostMapping("/cookie/studentId")
    public String getCookieStudentId(String studentId){
        System.out.println("studentId:"+studentId);
        return studentId;
    }

    @PostMapping("/cookie/adminId")
    public String getCookieAdminId(String adminId){
        System.out.println("adminId:"+adminId);
        return adminId;
    }
}
