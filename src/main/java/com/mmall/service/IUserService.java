package com.mmall.service;


import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by songy on 2017/12/2.
 */
public interface IUserService {

    //用户登录
    ServerResponse<User> login(String username, String password);

    //用户注册
    ServerResponse<String> register(User user);

    //用户校检
    ServerResponse<String> checkValid(String str, String type);

    //获取用户找回密码的问题
    ServerResponse selectQuestion(String username);

    //校检问题的答案
    ServerResponse checkAnswer(String username, String question, String answer);

    //忘记密码中重置密码
    ServerResponse forgetRestPassword(String username, String passwordNew, String forgetToken);

    //登录状态下重置密码
    ServerResponse<String> restPassword(String passwordOld, String passwordNew, User user);

    //更新个人信息
    ServerResponse<User> updateInformation(User user);

    //取用户详细信息
    ServerResponse<User> getInformation(Integer userId);

    //判断是否为管理员
    ServerResponse checkAdminRole(User user);
}
