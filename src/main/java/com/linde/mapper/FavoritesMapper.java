package com.linde.mapper;

import com.linde.domain.Favorites;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.linde.domain.Student.StudentFavorites;
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
public interface FavoritesMapper extends BaseMapper<Favorites> {

    @Select("SELECT com.company_name,hr.company_hr_name,pos.position_name,fav.student_favorites_time,fav.favorites_status " +
            "from tbl_favorites as fav " +
            "join tbl_position as pos on pos.position_id = fav.position_id " +
            "join tbl_company_hr as hr on hr.company_hr_id = pos.company_hr_id " +
            "join tbl_company as com on com.company_id = hr.company_id " +
            "where fav.student_id = #{studentId};")
    List<StudentFavorites> getStudentFavoriteByStudentId(String studentId);
}
