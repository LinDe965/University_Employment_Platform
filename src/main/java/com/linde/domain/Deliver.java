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
@TableName("tbl_deliver")
public class Deliver implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * æ”¶è—id
     */
    @TableId(value = "deliver_id", type = IdType.ASSIGN_ID)
    private String deliverId;

    /**
     * å­¦ç”Ÿid
     */
    private String studentId;

    /**
     * èŒä½id
     */
    private String positionId;

    private Integer deliverStatus;

    /**
     * æ”¶è—æ—¶é—´
     */
    private LocalDateTime deliverTime;


}
