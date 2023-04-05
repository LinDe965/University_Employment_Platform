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
 * @since 2023-04-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "company_id", type = IdType.ASSIGN_ID)
    private Long companyId;

    private String companyName;

    private String companyAddress;

    private String companyIndustry;

    private String companyIntroduction;

    private String companyDetail;


}
