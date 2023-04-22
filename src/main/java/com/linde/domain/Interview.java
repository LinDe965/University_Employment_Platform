package com.linde.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
    @TableId(value = "stu_interview_id", type = IdType.ASSIGN_ID)
    private String stuInterviewId;

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
    private LocalDateTime interviewTime;

    private String interviewAddress;

    private Integer interviewStudentStatus;
}
