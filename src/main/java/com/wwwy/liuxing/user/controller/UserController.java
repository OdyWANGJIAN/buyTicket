package com.wwwy.liuxing.user.controller;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.message.util.RandomNumUtil;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.user.dao.IUserDao;
import com.wwwy.liuxing.user.dto.UserDTO;
import com.wwwy.liuxing.user.service.IUserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    private static final Logger logger = Logger.getLogger(UserController.class);

    /**
     * 登录shiro
     */
    @RequestMapping("/login")
    @ResponseBody
    public String userLogin(String userName, String passWord, Model model) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, passWord);
        Subject subject = SecurityUtils.getSubject();
        try {
            //将用户输入的参数传给Realm验证
            subject.login(usernamePasswordToken);
            //可以调用登录用户名称传到前端页面
            model.addAttribute("userName", userName);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "{\"code\":0}";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return "{\"code\":2}";
        }
        return "{\"code\":1}";
    }

    /*
    * 用户注册
    * */
    @RequestMapping("/register")
    @ResponseBody
    public String userRegister(UserDTO userDTO, String inputCode) {
        try {
            boolean dto = userService.setUserDTO(userDTO, inputCode);
            if (dto) {
                return "{\"code\":1}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"code\":0}";
        }
        return "{\"code\":2}";
    }

    /*
    * 所有用户的信息
    * */
    @RequestMapping("/list")
    public String userInfo(Integer page, ModelMap modelMap) {
        try {
            PageInfo<UserDTO> pageInfo = userService.getUserInfo(page);
            List<UserDTO> userInfoList = pageInfo.getList();
            modelMap.addAttribute("pageInfo", pageInfo);
            modelMap.addAttribute("userInfoList", userInfoList);
            logger.info(userInfoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_userlist";
    }


    /*
    * 修改用户信息
    * */
    @RequestMapping("/update")
    public String updateUserInfo(UserDTO userDTO, ModelMap modelMap, HttpServletRequest request) {
        PageInfo<UserDTO> PageInfo = null;
        List<UserDTO> userInfoList1 = null;
        try {
            boolean b = userService.updateUserInfo(userDTO);
            logger.info(b);
            if (b) {
                String page = request.getParameter("page");
                int parseInt = Integer.parseInt(page);
                PageInfo = userService.getUserInfo(parseInt);
                userInfoList1 = PageInfo.getList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelMap.addAttribute("pageInfo", PageInfo);
        modelMap.addAttribute("userInfoList", userInfoList1);
        return "hou_userlist";
    }

    /*
    * 根据id获取用户信息进行预修改
    * */
    @RequestMapping("/preupdate")
    public String getUserInfoById(Integer userId, ModelMap model) {
        try {
            UserDTO userInfoList = userService.getUserInfoById(userId);
            logger.info(userInfoList);
            model.addAttribute("userInfoList", userInfoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pre_updete_userinfo";
    }

    /*
    * 条件查询用户信息，并分页
    * */
    @RequestMapping("anyInfo")
    public String criteriaQueryUser(String anyInfo, Integer page, Model modelMap) {
        try {
            PageInfo<UserDTO> pageInfo = userService.criteriaQueryUser(anyInfo, page);
            List<UserDTO> userInfoList = pageInfo.getList();
            modelMap.addAttribute("pageInfo", pageInfo);
            logger.info(pageInfo);
            modelMap.addAttribute("userInfoList", userInfoList);
            logger.info("================" + userInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("userInfoList", null);
        }
        return "hou_userlist";
    }
}
