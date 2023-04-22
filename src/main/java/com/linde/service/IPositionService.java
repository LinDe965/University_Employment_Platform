package com.linde.service;

import com.linde.domain.Admin.AdminPosition;
import com.linde.domain.Position;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
