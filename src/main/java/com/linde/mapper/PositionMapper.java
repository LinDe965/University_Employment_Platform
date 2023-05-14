package com.linde.mapper;

import com.linde.domain.Admin.AdminPosition;
import com.linde.domain.Pos.PositionDetail;
import com.linde.domain.Pos.PositionNews;
import com.linde.domain.Position;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Linde
 * @since 2023-04-02
 */

@Mapper
public interface PositionMapper extends BaseMapper<Position> {

    @Select("select position_id, " +
            "position_name," +
            "position_recruit_number," +
            "position_salary," +
            "position_require," +
            "position_create_time," +
            "pos.deleted," +
            "pos.enable " +
            "from tbl_position as pos " +
            "join tbl_company_hr as hr  on hr.company_hr_id = pos.company_hr_id " +
            "where pos.company_hr_id = #{companyHrId} and pos.deleted = 0;")
    List<Position> getByHrIdPositionInformation(String companyHrId);

    //admin职位信息管理
    @Select("select pos.position_id," +
            "com.company_name,hr.company_hr_name," +
            "pos.position_name,pos.position_recruit_number," +
            "pos.position_salary,pos.position_require," +
            "pos.position_create_time,pos.enable  " +
            "from tbl_position as pos " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id;")
    List<AdminPosition> getPositionByAdmin();
    //admin职位信息管理模糊搜索
    @Select("select com.company_name,hr.company_hr_name," +
            "pos.position_name,pos.position_recruit_number," +
            "pos.position_salary,pos.position_require," +
            "pos.position_create_time,pos.enable  " +
            "from tbl_position as pos " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where pos.position_name LIKE CONCAT('%', #{positionName}, '%');")
    List<AdminPosition> getPositionLikeByAdmin(String positionName);


    //招聘信息列表接口
    @Select("select pos.position_id," +
            "com.company_name,com.company_address,com.company_industry," +
            "hr.company_hr_name," +
            "pos.position_name,pos.position_salary,pos.position_create_time,pos.enable " +
            "from tbl_company as com " +
            "join tbl_company_hr as hr on com.company_id = hr.company_id " +
            "join tbl_position as pos on pos.company_hr_id = hr.company_hr_id " +
            "where pos.enable = 1;")
    List<PositionNews> getFrontPositionDetail();

    @Select("select com.company_name,com.company_address,com.company_industry,com.company_introduction,com.company_detail," +
            "pos.position_name,pos.position_salary,pos.position_require,pos.position_create_time,pos.position_recruit_number," +
            "hr.company_hr_name,hr.company_hr_tel,hr.company_hr_email " +
            "from tbl_company as com " +
            "join tbl_company_hr as hr on hr.company_id = com.company_id " +
            "join tbl_position as pos on pos.company_hr_id = hr.company_hr_id " +
            "where pos.position_id = #{positionId};")
    PositionDetail getFrontPositionDetailInformation(String positionId);
}
