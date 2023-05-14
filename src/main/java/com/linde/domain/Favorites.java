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
@TableName("tbl_favorites")
public class Favorites implements Serializable {

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

    private Integer favoritesStatus;

    /**
     * æ”¶è—æ—¶é—´
     */
    @TableField(value = "student_favorites_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime studentFavoritesTime;


}
