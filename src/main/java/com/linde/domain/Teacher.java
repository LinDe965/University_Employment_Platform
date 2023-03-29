package com.linde.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2023-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * è€å¸ˆid
     */
    @TableId(value = "teacher_id", type = IdType.ASSIGN_ID)
    private String teacherId;

    /**
     * ç”¨æˆ·id
     */
    private Long uid;

    /**
     * è€å¸ˆå§“å
     */
    private String teacherName;

    /**
     * è€å¸ˆæ‰‹æœºå·
     */
    private String teacherTel;

    /**
     * è€å¸ˆé‚®ç®±
     */
    private String teacherEmail;


}
