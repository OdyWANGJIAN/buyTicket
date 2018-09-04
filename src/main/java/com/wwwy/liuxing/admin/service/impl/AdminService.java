package com.wwwy.liuxing.admin.service.impl;

import com.wwwy.liuxing.admin.dao.IAdminDao;
import com.wwwy.liuxing.admin.dto.AdminDto;
import com.wwwy.liuxing.admin.service.IAdminService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/4/13.
 */
@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminDao adminDao;

    private static final Logger logger = Logger.getLogger(AdminService.class);

    /*
    * 判断管理员登录信息
    * */
    @Override
    public AdminDto checkUserNameAndPassWord(String adminName,String adminPassword ) throws Exception {
        AdminDto nameAndPassWord = adminDao.getNameAndPassWord(adminName);
        logger.info(nameAndPassWord);
        if (nameAndPassWord==null||"".equals(nameAndPassWord)) {
            throw new UnknownAccountException("用户名不存在");
        }
        SimpleHash md5 = new SimpleHash("MD5", adminPassword, nameAndPassWord.getAdminName());
        logger.info(md5);
        String adminPassword1 = nameAndPassWord.getAdminPassword();
        if (adminPassword1==null||!adminPassword1.equals(md5.toString())){
            throw new IncorrectCredentialsException("密码错误");
        }
        return nameAndPassWord;
    }
}
