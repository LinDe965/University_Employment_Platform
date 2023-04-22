package com.linde.service.impl;

import com.linde.domain.Admin.AdminPosition;
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

}
