package com.ppf.booklendingsystem.model.dto.book;

import com.ppf.booklendingsystem.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * 图书查询
 */
@Data
public class BookQueryRequest extends PageRequest implements Serializable {
    private String userName;
    private String bookName;
    private static final long serialVersionUID = 1L;
}
