package com.linde.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("tbl_admins")
public class Admins implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * è€å¸ˆid
     */
    @TableId(value = "admin_id", type = IdType.INPUT)
    private String adminId;

    /**
     * è€å¸ˆå§“å
     */
    private String adminName;

    /**
     * è€å¸ˆæ€§åˆ«
     */
    private String adminSex;

    /**
     * è€å¸ˆæ‰‹æœºå·
     */
    private String adminTel;

    /**
     * è€å¸ˆé‚®ç®±
     */
    private String adminEmail;

    /**
     * è€å¸ˆèŒä½
     */
    private String adminDepartment;

    /**
     * è€å¸ˆå²—ä½
     */
    private String adminPost;

    /**
     * å¯†ç 
     */
    @TableField(select = false)
    private String password;


}
