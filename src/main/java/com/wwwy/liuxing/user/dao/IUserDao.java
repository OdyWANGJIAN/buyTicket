package com.wwwy.liuxing.user.dao;

import com.wwwy.liuxing.user.dto.UserDTO;

import java.util.List;

/**
 * Created by Administrator on 2018/4/10.
 */
public interface IUserDao {

    /*
    * 前端用户登录接口
    * */
    UserDTO getNameAndPassWord(String userName)throws Exception;

    /*
    * 前端用户注册接口
    * */
    Integer setUserDto(UserDTO userDTO)throws Exception;

    /*
    * 查询所有用户信息
    * */
    List<UserDTO> getUserInfo()throws Exception;

    /*
    * 修改用户个人信息
    * */
    Integer updateUserInfo(UserDTO userDTO)throws Exception;

    /*
    * 根据id查询用户信息
    * */
     UserDTO getUserInfoById(Integer userId)throws Exception;

    /*
    * 条件查询
    * */
    List<UserDTO> criteriaQueryUser(String anyInfo)throws Exception;
}
