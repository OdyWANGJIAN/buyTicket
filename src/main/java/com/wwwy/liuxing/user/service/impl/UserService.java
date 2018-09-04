package com.wwwy.liuxing.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.message.controller.MessageController;
import com.wwwy.liuxing.message.util.RandomNumUtil;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.user.dao.IUserDao;
import com.wwwy.liuxing.user.dto.UserDTO;
import com.wwwy.liuxing.user.service.IUserService;
import com.wwwy.liuxing.user.utils.PassWordMd5;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
@Service
public class UserService implements IUserService{

    private static final Logger logger = Logger.getLogger(UserService.class);


    @Autowired
    private IUserDao userDao;

    @Autowired
    private RandomNumUtil randomNumUtil;
    /*
    * 登录业务
    * */
    @Override
    public UserDTO checkUserNameAndPassWord(String userName) throws Exception {
        return userDao.getNameAndPassWord(userName);
    }


    /*
    * 注册业务
    * */
    @Override
    public boolean setUserDTO(UserDTO userDTO,String inputCode) throws Exception {
        String telephone = userDTO.getUserTel();
        String randNum = randomNumUtil.getRand(telephone);
       /* String randNum = "234567";*/
        logger.info(randNum.hashCode());
        logger.info(inputCode.hashCode());
        if (randNum.equals(inputCode)){
            userDTO.setUserPassword(PassWordMd5.passWordMd5(userDTO));
            Integer i = userDao.setUserDto(userDTO);
            if (i>0){
                return true;
            }
        }
        return false;
    }

    /*
    * 查询所有用户信息业务
    * */
    @Override
    public PageInfo<UserDTO> getUserInfo(Integer page) throws Exception {
        Integer pageStart = SysConfig.BeforeConfig.PAGE_START;
        if (page==null||page<pageStart){
            page=pageStart;
        }
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<UserDTO> userInfo = userDao.getUserInfo();
        logger.info("................."+userInfo);
        PageInfo<UserDTO> userDTOPageInfo = new PageInfo<UserDTO>(userInfo);
        return userDTOPageInfo;
    }

    /*
    * 修改单个用户信息业务
    * */
    public boolean updateUserInfo(UserDTO userDTO)throws Exception{
        userDTO.setUserPassword(PassWordMd5.passWordMd5(userDTO));
        Integer integer = userDao.updateUserInfo(userDTO);
        logger.info(integer);
        if (integer>0){
            return true;
        }
        return false;
    }

    /*
    * 通过Id获取用户信息
    * */
    @Override
    public UserDTO getUserInfoById(Integer userId) throws Exception {
        return userDao.getUserInfoById(userId);
    }

    /*
    * 条件查询用户信息
    * */
    @Override
    public PageInfo<UserDTO> criteriaQueryUser(String anyInfo,Integer page) throws Exception {
        Integer start = SysConfig.BeforeConfig.PAGE_START;
        logger.info(start);
        if (page==null||page<start){
            page=start;
        }
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<UserDTO> userDTOList = userDao.criteriaQueryUser(anyInfo);
        logger.info(anyInfo);
        logger.info(userDTOList);
        PageInfo<UserDTO> userDTOPageInfo = new PageInfo<>(userDTOList);
        logger.info(userDTOPageInfo);
        return userDTOPageInfo;
    }
}
