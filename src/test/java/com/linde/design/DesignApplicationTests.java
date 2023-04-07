package com.linde.design;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.linde.domain.Admins;
import com.linde.domain.Company;
import com.linde.domain.CompanyHr;
import com.linde.domain.CompanyPosition;
import com.linde.service.impl.AdminsServiceImpl;
import com.linde.service.impl.CompanyHrServiceImpl;
import com.linde.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class DesignApplicationTests {

    @Autowired
    private AdminsServiceImpl adminsService;


    @Test
    public void test(){


    }

    @Test
    public void test1(){
        Admins admins = new Admins();
        admins.setAdminId("20230101");
        admins.setAdminName("zhangsan");
        admins.setAdminEmail("zhangsan@gmail.com");
        admins.setAdminTel("19912345678");
        admins.setAdminDepartment("教务处就业办");
        admins.setAdminPost("值班老师");
        adminsService.updateAdminsDetailsAll(admins);
    }

    @Test
    public void test2(){
        Admins admins = adminsService.getById("20230101");
        System.out.println(admins);
    }
}
