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
@TableName("tbl_signing")
public class Signing implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生签约id
     */
    @TableId(value = "signing_id", type = IdType.ASSIGN_ID)
    private String signingId;

    /**
     * 学生id
     */
    private String studentId;

    /**
     * 职位id
     */
    private String positionId;

    /**
     * 签约状态
     */
    private Integer signingStatus;

    /**
     * 签约时间
     */
    @TableField(value = "signing_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime signingTime;

    private String signingAddress;

    private Integer signingStudentStatus;
}
