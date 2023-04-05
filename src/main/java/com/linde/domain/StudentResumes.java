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
@TableName("tbl_student_resumes")
public class StudentResumes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ç®€åŽ†è¯¦æƒ…id
     */
    @TableId(value = "student_resume_id", type = IdType.ASSIGN_ID)
    private Long studentResumeId;

    /**
     * å­¦ç”Ÿid
     */
    private String studentId;

    /**
     * å­¦ç”Ÿç»åŽ†
     */
    private String resumeExperience;

    /**
     * å­¦ç”ŸæŠ€èƒ½
     */
    private String resumeSkills;

    /**
     * å­¦ç”Ÿè‡ªæˆ‘è¯„ä»·
     */
    private String resumeEvaluation;

    /**
     * å­¦ç”ŸæœŸæœ›è–ªèµ„
     */
    private String resumeSalaryExpectation;


}
