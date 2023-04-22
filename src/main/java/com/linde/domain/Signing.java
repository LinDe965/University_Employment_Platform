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
@TableName("tbl_signing")
public class Signing implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生签约id
     */
    @TableId(value = "stu_signing_id", type = IdType.ASSIGN_ID)
    private String stuSigningId;

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
    private LocalDateTime signingTime;

    private String signingAddress;

    private Integer signingStudentStatus;
}
