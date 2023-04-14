package com.linde.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@TableName("tbl_company_hr")
public class CompanyHr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "company_hr_id", type = IdType.ASSIGN_ID)
    private Long companyHrId;

    private Long companyId;

    private String companyHrName;

    private String companyHrTel;

    private String companyHrEmail;

    private String password;

    @TableLogic(value = "0" , delval = "1")
    private Integer deleted;

    private String role;

}
