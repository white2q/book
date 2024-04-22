package com.ppf.booklendingsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ppf.booklendingsystem.common.BaseResponse;
import com.ppf.booklendingsystem.common.ErrorCode;
import com.ppf.booklendingsystem.common.ResultUtils;
import com.ppf.booklendingsystem.constant.UserConstant;
import com.ppf.booklendingsystem.exception.BusinessException;
import com.ppf.booklendingsystem.exception.ThrowUtils;
import com.ppf.booklendingsystem.model.dto.book.BookLendRequest;
import com.ppf.booklendingsystem.model.dto.book.BookQueryRequest;
import com.ppf.booklendingsystem.model.dto.book.BookUpdateRequest;
import com.ppf.booklendingsystem.model.entity.Book;
import com.ppf.booklendingsystem.model.entity.User;
import com.ppf.booklendingsystem.service.BookService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookService bookService;

    /**
     * 分页获取图书列表
     *
     * @param bookQueryRequest
     * @return
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<Book>> listBookByPage(@RequestBody BookQueryRequest bookQueryRequest) {
        long current = bookQueryRequest.getCurrent();
        long size = bookQueryRequest.getPageSize();
        String bookName = bookQueryRequest.getBookName();
        String userName = bookQueryRequest.getUserName();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(ObjectUtils.isNotEmpty(bookName), "bookName", bookName);
        queryWrapper.like(ObjectUtils.isNotEmpty(userName), "userName", userName);
        Page<Book> bookPage = bookService.page(new Page<>(current, size), queryWrapper);
        return ResultUtils.success(bookPage);
    }

    @PostMapping("/option")
    public BaseResponse<Boolean> bookOption(@RequestBody BookLendRequest bookLendRequest, HttpServletRequest request) {
        long id = bookLendRequest.getId();
        int status = bookLendRequest.getStatus();
        User user = (User) request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<>();
        bookQueryWrapper.eq("id", id);
        Book book = bookService.getOne(bookQueryWrapper);
        book.setUserName(user.getUserName());
        book.setStatus(status);
        return ResultUtils.success(bookService.updateById(book));
    }
}
