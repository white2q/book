package com.ppf.booklendingsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ppf.booklendingsystem.common.ErrorCode;
import com.ppf.booklendingsystem.exception.BusinessException;
import com.ppf.booklendingsystem.mapper.BookMapper;
import com.ppf.booklendingsystem.model.dto.book.BookQueryRequest;
import com.ppf.booklendingsystem.model.entity.Book;
import com.ppf.booklendingsystem.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author 25137
 * @description 针对表【book(图书)】的数据库操作Service实现
 * @createDate 2024-04-22 10:58:12
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
        implements BookService {
    @Override
    public QueryWrapper<Book> getQueryWrapper(BookQueryRequest book) {
        if (book == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        return queryWrapper;
    }
}




