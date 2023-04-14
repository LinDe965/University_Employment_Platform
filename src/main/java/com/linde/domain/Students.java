package com.linde.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.time.Year;
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
@TableName("tbl_students")
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * å­¦å·
     */
    @TableId(value = "student_id", type = IdType.INPUT)
    private String studentId;

    /**
     * å¯†ç 
     */

    @TableField(select = false)
    private String password;

    /**
     * å­¦ç”Ÿå§“å
     */
    private String studentName;

    private String role;

    /**
     * å­¦ç”Ÿæ€§åˆ«
     */
    private String studentSex;

    /**
     * å­¦ç”Ÿå¹´é¾„
     */
    private Integer studentAge;

    /**
     * å­¦ç”Ÿæ‰‹æœºå·
     */
    private String studentTel;

    /**
     * å­¦ç”Ÿé‚®ç®±
     */
    private String studentEmail;

    /**
     * å­¦ç”Ÿèº«ä»½è¯
     */
    private String studentIdCards;

    /**
     * å­¦ç”Ÿæ‰€åœ¨é™¢
     */
    private String studentDepartment;

    /**
     * å­¦ç”Ÿä¸“ä¸š
     */
    private String studentSubject;

    /**
     * å­¦ç”Ÿæ¯•ä¸šå¹´ä»½
     */
    private Year studentEndYear;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;


}
