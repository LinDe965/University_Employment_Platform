package com.linde.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
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
    private LocalDateTime date;

    private Integer enable;

    @TableLogic(value = "0" , delval = "1")
    private Integer deleted;

}
