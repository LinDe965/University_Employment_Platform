package com.linde.mapper;

import com.linde.domain.Admin.AdminPosition;
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

    @Select("select position_name,position_recruit_number,position_salary,position_require,position_create_time " +
            "from tbl_position " +
            "join tbl_company_hr on tbl_position.company_hr_id = tbl_company_hr.company_hr_id " +
            "where tbl_position.company_hr_id = #{companyHrId};")
    List<Position> getByHrIdPositionInformation(String companyHrId);

    @Select("select com.company_name,hr.company_hr_name,pos.position_name,pos.position_recruit_number,pos.position_salary,pos.position_require,pos.position_create_time " +
            "from tbl_position as pos " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id;")
    List<AdminPosition> getPositionByAdmin();
}
