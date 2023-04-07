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
 * @since 2023-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_student_status")
public class StudentStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生状态id
     */
    @TableId(value = "status_id", type = IdType.ASSIGN_ID)
    private String statusId;

    /**
     * 学生id
     */
    private String studentId;

    /**
     * 学生投递状态
     */
    private Integer statusStudentDelivery;

    /**
     * 学生投递时间
     */
    private LocalDateTime statusStudentDeliveryTime;

    /**
     * hr同意面试状态
     */
    private Integer statusEnableHr;

    /**
     * hr同意面试时间
     */
    private LocalDateTime statusEnableHrTime;

    /**
     * 学生同意面试状态
     */
    private Integer statusEnableStudent;

    /**
     * 学生同意面试时间
     */
    private LocalDateTime statusEnableStudentTime;

    /**
     * hr录用状态
     */
    private Integer statusEnableEmploy;

    /**
     * hr录用时间
     */
    private LocalDateTime statusEnableEmployTime;

    /**
     * 学生同意入职状态
     */
    private LocalDateTime statusStudentAgreeTime;

    /**
     * 学生同意入职时间
     */
    private Integer statusStudentAgree;


}
