package com.wwwy.liuxing.admin.dao.impl;

import com.wwwy.liuxing.admin.dao.IAdminDao;
import com.wwwy.liuxing.admin.dto.AdminDto;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/4/13.
 */
@Repository
public class AdminDao extends SqlSessionDaoSupport implements IAdminDao{

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public AdminDto getNameAndPassWord(String adminName) throws Exception {
        return getSqlSession().selectOne("com.wwwy.liuxing.user.dto.AdminMapper.getNameAndPassWord",adminName);
    }
}
