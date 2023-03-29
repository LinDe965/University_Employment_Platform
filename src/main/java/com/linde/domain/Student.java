package com.linde.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.Year;
import java.time.LocalDateTime;
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
@TableName("tbl_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * å­¦å·
     */
    @TableId(value = "student_id", type = IdType.ASSIGN_ID)
    private String studentId;

    /**
     * ç”¨æˆ·id
     */
    private Long uid;


    private String name;


    /**
     * å­¦ç”Ÿå¹´é¾„
     */
    private Integer studentAge;

    /**
     * å­¦ç”Ÿæ€§åˆ«
     */
    private String studentSex;

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
     * å­¦ç”Ÿæ‰€åœ¨ç³»
     */
    private String studentSubject;

    /**
     * å­¦ç”Ÿä¸Šå­¦å¹´ä»½
     */
    private Year studentStartYear;

    /**
     * å­¦ç”Ÿæ¯•ä¸šå¹´ä»½
     */
    private Year studentEndYear;

    /**
     * å­¦ç”Ÿä¸ªäººå±¥åŽ†
     */
    private String studentPersonalDetails;

    /**
     * å­¦ç”ŸæŠ•é€’æ—¶é—´
     */
    private LocalDateTime studentDeliverTime;


}
