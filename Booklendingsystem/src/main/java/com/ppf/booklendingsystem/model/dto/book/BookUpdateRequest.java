package com.ppf.booklendingsystem.model.dto.book;

import lombok.Data;

import java.io.Serializable;

/**
 * 图书更新
 */
@Data
public class BookUpdateRequest implements Serializable {
    private long id;
    private int status;
    private static final long serialVersionUID = 1L;

}
