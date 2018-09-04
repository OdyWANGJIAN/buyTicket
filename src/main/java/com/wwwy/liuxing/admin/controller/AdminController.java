package com.wwwy.liuxing.admin.controller;

import com.wwwy.liuxing.admin.dto.AdminDto;
import com.wwwy.liuxing.admin.service.IAdminService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/4/13.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private IAdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    String adminLogin(String adminName, String adminPassword, Model model) {
        try {
            AdminDto adminDto = adminService.checkUserNameAndPassWord(adminName, adminPassword);
            logger.info(adminDto);
            model.addAttribute("adminName",adminName);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "{\"code\":0}";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return "{\"code\":2}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"code\":3}";
        }
        return "{\"code\":1}";
    }
}