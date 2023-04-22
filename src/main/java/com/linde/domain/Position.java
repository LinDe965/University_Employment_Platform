package com.linde.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("tbl_position")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * èŒä½id
     */
    @TableId(value = "position_id", type = IdType.ASSIGN_ID)
    private String positionId;

    /**
     * å²—ä½id
     */
    private String postId;

    /**
     * hrçš„id
     */
    private String companyHrId;

    /**
     * èŒä½åç§°
     */
    private String positionName;

    /**
     * èŒä½æ‹›æ”¶äººæ•°
     */
    private Integer positionRecruitNumber;

    /**
     * èŒä½è–ªèµ„
     */
    private Integer positionSalary;

    /**
     * èŒä½è¦æ±‚
     */
    private String positionRequire;

    /**
     * å‘å¸ƒèŒä½æ—¶é—´
     */
    @TableField(value = "position_create_time",fill =FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime positionCreateTime;

    @TableField(value = "position_update_time",fill =FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime positionUpdateTime;

    @TableLogic(value = "0" , delval = "1")
    private Integer deleted;

}
