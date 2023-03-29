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
@TableName("tbl_company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * å…¬å¸åç§°
     */
    @TableId(value = "company_id", type = IdType.ASSIGN_ID)
    private String companyId;

    /**
     * å…¬å¸åå­—
     */
    private String companyName;

    /**
     * å…¬å¸é‚®ç®±
     */
    private String companyEmail;

    /**
     * å…¬å¸è”ç³»æ–¹å¼
     */
    private String companyTel;

    /**
     * å…¬å¸åœ°å€
     */
    private String companyAddress;

    /**
     * å…¬å¸ç®€ä»‹
     */
    private String companyIntroduction;

    /**
     * å…¬å¸è¡Œä¸š
     */
    private String companyIndustry;


    private String companyDetail;
}
