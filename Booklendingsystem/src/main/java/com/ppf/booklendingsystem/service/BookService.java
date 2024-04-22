package com.ppf.booklendingsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ppf.booklendingsystem.model.dto.book.BookQueryRequest;
import com.ppf.booklendingsystem.model.entity.Book;

/**
 * @author 25137
 * @description 针对表【book(图书)】的数据库操作Service
 * @createDate 2024-04-22 10:58:12
 */
public interface BookService extends IService<Book> {

    /**
     * 获取查询条件
     *
     * @param book
     * @return
     */
    QueryWrapper<Book> getQueryWrapper(BookQueryRequest book);
}
