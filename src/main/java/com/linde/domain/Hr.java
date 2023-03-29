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
 * @since 2023-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_hr")
public class Hr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * hrçš„id
     */
    @TableId(value = "hr_id", type = IdType.ASSIGN_ID)
    private String hrId;

    /**
     * hrçš„ç”¨æˆ·id
     */
    private Long uid;

    /**
     * hrå¯¹åº”å…¬å¸id
     */
    private String companyId;

    /**
     * hrå§“å
     */
    private String hrName;

    /**
     * hræ‰‹æœºå·
     */
    private String hrTel;

    /**
     * hré‚®ç®±
     */
    private String hrEmail;


}
