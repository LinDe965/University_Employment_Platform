package com.linde.service;

import com.linde.domain.Admin.AdminPosition;
import com.linde.domain.Pos.PositionDetail;
import com.linde.domain.Pos.PositionNews;
import com.linde.domain.Position;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Linde
 * @since 2023-04-02
 */
public interface IPositionService extends IService<Position> {

    //public Position createPosition(Long companyHrId , Position position);

    List<Position> getByHrIdPositionInformation(String companyHrId);

    List<AdminPosition> getPositionByAdmin();

    //招聘信息列表接口
    List<PositionNews> getFrontPositionDetail();

    PositionDetail getFrontPositionDetailInformation(String positionId);

    List<AdminPosition> getPositionLikeByAdmin(String positionName);


}
