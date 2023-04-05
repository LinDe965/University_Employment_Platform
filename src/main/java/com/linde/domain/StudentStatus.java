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
 * @since 2023-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_student_status")
public class StudentStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * å­¦ç”ŸçŠ¶æ€id
     */
    @TableId(value = "status_id", type = IdType.ASSIGN_ID)
    private String statusId;

    /**
     * å­¦ç”Ÿid
     */
    private String studentId;

    /**
     * hråŒæ„æ˜¯å¦é¢è¯•
     */
    private Integer statusEnableHr;

    /**
     * hrå…è®¸é¢è¯•çš„æ“ä½œæ—¶é—´
     */
    private LocalDateTime statusEnableHrTime;

    /**
     * hråŒæ„æ˜¯å¦è¢«å½•ç”¨
     */
    private Integer statusEnableEmploy;

    /**
     * hrå½•ç”¨çš„æ“ä½œæ—¶é—´
     */
    private LocalDateTime statusEnableEmployTime;

    /**
     * å­¦ç”Ÿæ˜¯å¦å‚åŠ é¢è¯•
     */
    private Integer statusEnableStudent;

    /**
     * å­¦ç”ŸåŒæ„é¢è¯•çš„æ“ä½œæ—¶é—´
     */
    private LocalDateTime statusEnableStudentTime;


}
