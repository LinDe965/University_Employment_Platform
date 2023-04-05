package com.linde.service;

import com.linde.domain.Students;
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
public interface IStudentsService extends IService<Students> {
    public boolean updateStudentsPasswordById(String studentId,String password);
}
