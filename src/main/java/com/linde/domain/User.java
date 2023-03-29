package com.linde.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Linde
 * @since 2023-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ç”¨æˆ·id
     */
    @TableId(value = "uid", type = IdType.ASSIGN_ID)
    private Long uid;

    /**
     * ç”¨æˆ·å
     */
    private String username;

    /**
     * å¯†ç 
     */
    @TableField(select = false)
    private String password;

    /**
     * ç”¨æˆ·è§’è‰²
     */
    private String role;

    /**
     * ç”¨æˆ·å¯ç”¨
     */
    @TableLogic(value = "1" ,delval = "0")
    private Integer enable;


}
