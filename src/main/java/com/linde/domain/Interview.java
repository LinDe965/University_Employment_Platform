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
 * @since 2023-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_interview")
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "interview_id", type = IdType.ASSIGN_ID)
    private Long interviewId;

    private Long companyHrId;

    private String studentName;

    private String positionName;

    private String interviewAddress;

    private LocalDateTime interviewTime;

    private String enable;


}
