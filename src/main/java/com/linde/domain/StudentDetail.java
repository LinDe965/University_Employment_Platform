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
 * @since 2023-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_student_detail")
public class StudentDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ç®€åŽ†è¯¦æƒ…id
     */
    @TableId(value = "student_detail_id", type = IdType.ASSIGN_ID)
    private String studentDetailId;

    /**
     * å­¦ç”Ÿid
     */
    private String studentId;

    /**
     * å­¦ç”Ÿç»åŽ†
     */
    private String detailExperience;

    /**
     * å­¦ç”ŸæŠ€èƒ½
     */
    private String detailSkills;

    /**
     * å­¦ç”Ÿè‡ªæˆ‘è¯„ä»·
     */
    private String detailEvaluation;


}
