package com.linde.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Linde
 * @since 2023-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * å²—ä½id
     */
    @TableId(value = "post_id", type = IdType.ASSIGN_ID)
    private String postId;

    /**
     * è€å¸ˆid
     */
    private String adminId;

    /**
     * å²—ä½ç±»åž‹
     */
    private String postType;

    /**
     * å²—ä½åç§°
     */
    private String postName;


}
