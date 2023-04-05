package com.linde.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.linde.domain.Admins;
import com.linde.domain.Students;
import com.linde.mapper.AdminsMapper;
import com.linde.mapper.StudentsMapper;
import com.linde.service.IAdminsService;
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
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins> implements IAdminsService {

    @Autowired
    private AdminsMapper adminsMapper;

    @Override
    public boolean updateAdminsPasswordById(String adminId,String password) {
        Admins admins = new Admins();
        admins.setAdminId(adminId);
        admins.setPassword(password);
        return adminsMapper.updateById(admins) > 0;
    }

    @Override
    public boolean updateAdminsDetailsAll(Admins admins) {
        LambdaUpdateWrapper<Admins> adminsLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        adminsLambdaUpdateWrapper
                .eq(Admins::getAdminId,admins.getAdminId())
                .set(Admins::getAdminName,admins.getAdminName())
                .set(Admins::getAdminTel,admins.getAdminTel())
                .set(Admins::getAdminEmail,admins.getAdminEmail())
                .set(Admins::getAdminDepartment,admins.getAdminDepartment())
                .set(Admins::getAdminPost,admins.getAdminPost());
        return adminsMapper.update(admins,adminsLambdaUpdateWrapper)>0;
    }


}
