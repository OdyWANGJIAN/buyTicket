package com.wwwy.liuxing.admin.service;

import com.wwwy.liuxing.admin.dto.AdminDto;

/**
 * Created by Administrator on 2018/4/13.
 */

public interface IAdminService {

        /*
        * 管理员登录判断接口
        * */
    AdminDto checkUserNameAndPassWord(String AdminName,String AdminPassword)throws Exception;
}
