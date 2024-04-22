package com.ppf.booklendingsystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书
 *
 * @TableName book
 */
@TableName(value = "book")
@Data
public class Book implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 图书名称
     */
    @TableField(value = "bookName")
    private String bookName;

    /**
     * 借阅状态
     * 0-init 1-借阅中 2-已归还
     */
    private Integer status;

    /**
     * 借阅人名称
     */
    @TableField(value = "userName")
    private String userName;

    /**
     * 创建时间
     */
    @TableField(value = "createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "updateTime")
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableField(value = "isDelete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}