package com.linde.design;


import com.linde.domain.Admins;
import com.linde.domain.Interview;
import com.linde.service.impl.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignApplicationTests {

    @Autowired
    private AdminsServiceImpl adminsService;

    @Autowired
    private PositionServiceImpl positionService;

    @Autowired
    private DeliverServiceImpl deliverService;

    @Autowired
    private StudentResumesServiceImpl studentResumesService;

    @Autowired
    private InterviewServiceImpl interviewService;

    @Autowired
    private StudentsServiceImpl studentsService;

    @Test
    public void studentTest(){
        String studentId = "211999888";
        System.out.println("结果为："+studentsService.getStudentResumesByStudentId(studentId));
    }

    @Test
    public void test(){
        String hrId = "1643174176988614658";
        System.out.println("查询结果："+interviewService.getStudentInterviewByHrId(hrId));
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
