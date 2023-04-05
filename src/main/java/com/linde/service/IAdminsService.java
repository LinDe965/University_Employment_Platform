package com.linde.service;

import com.linde.domain.Admins;
import com.baomidou.mybatisplus.extension.service.IService;
import com.linde.domain.Students;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Linde
 * @since 2023-04-02
 */
public interface IAdminsService extends IService<Admins> {

    public boolean updateAdminsPasswordById(String adminId,String password);

    public boolean updateAdminsDetailsAll(Admins admins);

}
