package com.linde.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.linde.domain.Admin.AdminPosition;
import com.linde.domain.Pos.PositionDetail;
import com.linde.domain.Pos.PositionNews;
import com.linde.domain.Position;
import com.linde.mapper.PositionMapper;
import com.linde.service.IPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Linde
 * @since 2023-04-02
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public List<Position> getByHrIdPositionInformation(String companyHrId) {
        return positionMapper.getByHrIdPositionInformation(companyHrId);
    }

    @Override
    public List<AdminPosition> getPositionByAdmin() {
        return positionMapper.getPositionByAdmin();
    }

    //招聘信息列表接口
    @Override
    public List<PositionNews> getFrontPositionDetail() {
        return positionMapper.getFrontPositionDetail();
    }

    @Override
    public PositionDetail getFrontPositionDetailInformation(String positionId) {
        return positionMapper.getFrontPositionDetailInformation(positionId);
    }

    @Override
    public List<AdminPosition> getPositionLikeByAdmin(String positionName) {
        return positionMapper.getPositionLikeByAdmin(positionName);
    }


}
