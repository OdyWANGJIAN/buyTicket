package com.wwwy.liuxing.user.utils;

import com.wwwy.liuxing.user.dto.UserDTO;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by Administrator on 2018/4/14.
 */

public class PassWordMd5 {

    /*
    * md5密码加密工具类
    * */
    public final static String passWordMd5(UserDTO userDTO){
        String md5 = new SimpleHash("MD5", userDTO.getUserPassword(), userDTO.getUserName()).toString();
        return md5;
    }
}
