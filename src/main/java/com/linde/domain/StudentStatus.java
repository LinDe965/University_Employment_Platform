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
 * @since 2023-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_student_status")
public class StudentStatus implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * ????????????id
     */
    @TableId(value = "status_id", type = IdType.ASSIGN_ID)
    private String statusId;

    /**
     * ??????id
     */
    private String studentId;

    /**
     * hr????????????é??è??
     */

    @TableLogic(value = "0" ,delval = "1")
    private Integer statusEnableHr;

    /**
     * hr???è??é??è??????????????é??
     */
    private LocalDateTime statusEnableHrTime;

    /**
     * hr????????????è???????¨
     */
    @TableLogic(value = "0" ,delval = "1")
    private Integer statusEnableEmploy;

    /**
     * hr?????¨????????????é??
     */
    private LocalDateTime statusEnableEmployTime;

    /**
     * ??????????????????é??è??
     */
    @TableLogic(value = "0" ,delval = "1")
    private Integer statusEnableStudent;

    /**
     * ????????????é??è??????????????é??
     */
    private LocalDateTime statusEnableStudentTime;


}
