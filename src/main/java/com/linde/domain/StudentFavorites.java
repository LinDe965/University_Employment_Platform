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
@TableName("tbl_student_favorites")
public class StudentFavorites implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * æ”¶è—id
     */
    @TableId(value = "favorites_id", type = IdType.ASSIGN_ID)
    private String favoritesId;

    /**
     * å­¦ç”Ÿid
     */
    private String studentId;

    /**
     * èŒä½id
     */
    private String positionId;

    /**
     * æ”¶è—æ—¶é—´
     */
    private LocalDateTime date;


}
