package com.wwwy.liuxing.admin.dao;

import com.wwwy.liuxing.admin.dto.AdminDto;

/**
 * Created by Administrator on 2018/4/13.
 */
public interface IAdminDao {

    /*
  * 管理员登录接口
  * */
    AdminDto getNameAndPassWord(String userName)throws Exception;

}
