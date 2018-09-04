package com.wwwy.liuxing.user.service;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.user.dto.UserDTO;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
public interface IUserService {

    /*
    * 登录判断
    * */
    UserDTO checkUserNameAndPassWord(String userName)throws Exception;

    /*
    * 注册
    * */
    boolean setUserDTO(UserDTO userDTO,String inputCode)throws Exception;

    /*
    * 后台查询
    * */
    PageInfo<UserDTO> getUserInfo(Integer page)throws Exception;

    /*
    * 修改信息
    * */
    boolean updateUserInfo(UserDTO userDTO)throws Exception;
    /*
    * 根据ID获取信息
    * */
    UserDTO getUserInfoById(Integer userId)throws Exception;

    /*
    * 条件查询
    * */
    PageInfo<UserDTO> criteriaQueryUser(String anyInfo, Integer page)throws Exception;
}
