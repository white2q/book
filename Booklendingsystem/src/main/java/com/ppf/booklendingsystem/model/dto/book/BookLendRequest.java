package com.ppf.booklendingsystem.model.dto.book;

import lombok.Data;

@Data
public class BookLendRequest {
    private long id;
    private int status;
}
