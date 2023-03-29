package com.linde.mapper;

import com.linde.domain.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Linde
 * @since 2023-03-28
 */

@Mapper
public interface PostMapper extends BaseMapper<Post> {

}
