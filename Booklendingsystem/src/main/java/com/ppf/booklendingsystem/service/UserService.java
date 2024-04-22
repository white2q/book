package com.ppf.booklendingsystem.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ppf.booklendingsystem.model.entity.User;
import com.ppf.booklendingsystem.model.vo.LoginUserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 25137
 * @description 针对表【user(用户)】的数据库操作Service
 * @createDate 2024-04-22 10:58:12
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);


    /**
     * 获取脱敏的已登录用户信息
     *
     * @return
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 获取当前登录用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 获取查询条件
     *
     * @param user
     * @return
     */
    QueryWrapper<User> getQueryWrapper(User user);

}
