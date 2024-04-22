package com.ppf.booklendingsystem.mapper;

import com.ppf.booklendingsystem.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 25137
* @description 针对表【user(用户)】的数据库操作Mapper
* @createDate 2024-04-22 10:58:12
* @Entity com.ppf.booklendingsystem.model.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




