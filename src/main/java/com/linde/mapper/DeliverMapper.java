package com.linde.mapper;

import com.linde.domain.Deliver;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linde.domain.Hr.HrStudentDeliver;
import com.linde.domain.Student.StudentDeliver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Linde
 * @since 2023-04-17
 */
@Mapper
public interface DeliverMapper extends BaseMapper<Deliver> {

    //WHERE s.name LIKE CONCAT('%', #{name}, '%')
    @Select("select deliver.deliver_id, stu.student_name,stu.student_subject,pos.position_name," +
            "deliver.deliver_status,deliver.deliver_time " +
            "from tbl_deliver as deliver " +
            "join tbl_students as stu on deliver.student_id = stu.student_id " +
            "JOIN tbl_position as pos on deliver.position_id = pos.position_id " +
            "JOIN tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "where hr.company_hr_id = #{companyHrId} and " +
            "stu.student_name LIKE CONCAT('%', #{studentName}, '%');")
    List<HrStudentDeliver> getPositionLikeByHr(String companyHrId,String studentName);

    @Select("select deliver.deliver_id, stu.student_name,stu.student_subject,pos.position_name," +
            "deliver.deliver_status,deliver.deliver_time " +
            "from tbl_deliver as deliver " +
            "join tbl_students as stu on deliver.student_id = stu.student_id " +
            "JOIN tbl_position as pos on deliver.position_id = pos.position_id " +
            "JOIN tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "where hr.company_hr_id = #{companyHrId}")
    public List<HrStudentDeliver> getStudentDeliver(String companyHrId);


    //stu端数据回显
    @Select("select com.company_name,pos.position_name,deliver.deliver_time,deliver.deliver_status " +
            "from tbl_deliver as deliver " +
            "join tbl_position as pos on pos.position_id = deliver.position_id " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where deliver.student_id = #{studentId};")
    public List<StudentDeliver> getStudentDeliverByStudentId(String studentId);


    //模糊搜索
    @Select("select com.company_name,pos.position_name,deliver.deliver_time,deliver.deliver_status " +
            "from tbl_deliver as deliver " +
            "join tbl_position as pos on pos.position_id = deliver.position_id " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where deliver.student_id = #{studentId} and " +
            "pos.position_name LIKE CONCAT('%', #{positionName}, '%');")
    public List<StudentDeliver> getStudentDeliverLikeByStudent(String studentId,String positionName);
}
