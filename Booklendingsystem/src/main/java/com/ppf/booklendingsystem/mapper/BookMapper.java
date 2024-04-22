package com.ppf.booklendingsystem.mapper;

import com.ppf.booklendingsystem.model.entity.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 25137
* @description 针对表【book(图书)】的数据库操作Mapper
* @createDate 2024-04-22 10:58:12
* @Entity com.ppf.booklendingsystem.model.entity.Book
*/
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}




