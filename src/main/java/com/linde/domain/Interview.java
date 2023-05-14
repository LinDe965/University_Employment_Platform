package com.linde.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Linde
 * @since 2023-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_interview")
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 面试id
     */
    @TableId(value = "interview_id", type = IdType.ASSIGN_ID)
    private String interviewId;

    /**
     * 学生id
     */
    private String studentId;

    /**
     * 职位id
     */
    private String positionId;

    /**
     * 面试状态
     */
    private Integer interviewStatus;

    /**
     * 面试时间
     */
    @TableField(value = "interview_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime interviewTime;

    private String interviewAddress;

    private Integer interviewStudentStatus;
}
