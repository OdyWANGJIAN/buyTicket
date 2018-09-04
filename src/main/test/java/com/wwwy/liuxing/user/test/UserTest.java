package com.wwwy.liuxing.user.test;


import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.admin.dao.IAdminDao;
import com.wwwy.liuxing.admin.dto.AdminDto;
import com.wwwy.liuxing.admin.service.IAdminService;
import com.wwwy.liuxing.user.dto.UserDTO;
import com.wwwy.liuxing.user.dao.IUserDao;
import com.wwwy.liuxing.user.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class UserTest {

    private static final Logger logger = Logger.getLogger(UserTest.class);

    @Autowired
    private IAdminDao adminDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserService userService;


    @Autowired
    private IAdminService adminService;

    @Test
    public void testLogin(){
        UserDTO zhangsan = null;
        try {
            zhangsan = userDao.getNameAndPassWord("laowang");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(zhangsan);
    }

    @Test
    public void testLoginService(){
        try {
            UserDTO userNameAndPassWord = userService.checkUserNameAndPassWord("zhangsan");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Test
    public void testAdminDao(){
        try {
            AdminDto zhangsan = adminDao.getNameAndPassWord("dsdasd");
            logger.info("=============="+zhangsan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAdminService(){
        try {
            AdminDto zhangsan = adminService.checkUserNameAndPassWord("zhangsan", "`12qwe");
            logger.info(zhangsan);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUserInfo(){
        try {
            List<UserDTO> userInfo = userDao.getUserInfo();
            for (UserDTO userDTO:userInfo){
                logger.info(userDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUserService(){
        try {
            PageInfo<UserDTO> userInfo1 = userService.getUserInfo(1);
            logger.info(userInfo1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateUserInfo(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(6);
        userDTO.setUserName("laowang");
        userDTO.setUserPassword("123456");
        userDTO.setUserRealName("老王");
        userDTO.setUserTel("124524524521");
        try {
            Integer integer = userDao.updateUserInfo(userDTO);
            logger.info(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateUserInfoService(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(6);
        userDTO.setUserName("laowang");
        userDTO.setUserPassword("123456");
        userDTO.setUserRealName("老王");
        userDTO.setUserTel("23123123123");
        try {
            boolean b = userService.updateUserInfo(userDTO);
            logger.info("==================="+b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUserById(){
        try {
            UserDTO userInfoById = userDao.getUserInfoById(1);
            logger.info(userInfoById);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUserByIdService(){
        try {
            UserDTO userInfoById = userDao.getUserInfoById(1);
            logger.info(userInfoById);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCriteriaQueryUser(){
        try {
            List<UserDTO> userDTOs = userDao.criteriaQueryUser("laowang");
            logger.info("================"+userDTOs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCriteriaQueryUserService(){
        PageInfo<UserDTO> pageInfo = null;
        try {
            pageInfo = userService.criteriaQueryUser("张三",1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(pageInfo);
    }
}
