package com.wwwy.liuxing.user.dao.impl;

import com.wwwy.liuxing.user.dao.IUserDao;
import com.wwwy.liuxing.user.dto.UserDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/4/10.
 */
@Repository
public class UserDao extends SqlSessionDaoSupport implements IUserDao {
    /*
    *全局唯一sqlSessionFactory，交由spirng管理
    * */
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public UserDTO getNameAndPassWord(String userName) throws Exception {
        return getSqlSession().selectOne("com.wwwy.liuxing.user.dto.UserMapper.getNameAndPassWord",userName);
    }

    public Integer setUserDto(UserDTO userDTO) throws Exception {
        Integer insert = getSqlSession().insert("com.wwwy.liuxing.user.dto.UserMapper.setUserRegister",userDTO);
        return insert;
    }

    @Override
    public List<UserDTO> getUserInfo() throws Exception {
        List<UserDTO> list = getSqlSession().selectList("com.wwwy.liuxing.user.dto.UserMapper.getUserInfo");
        return list;
    }

    @Override
    public Integer updateUserInfo(UserDTO userDTO) throws Exception {
        return getSqlSession().update("com.wwwy.liuxing.user.dto.UserMapper.updateUserInfo", userDTO);
    }

    @Override
    public UserDTO getUserInfoById(Integer userId) throws Exception {
        return getSqlSession().selectOne("com.wwwy.liuxing.user.dto.UserMapper.getUserById",userId);
    }

    @Override
    public List<UserDTO> criteriaQueryUser(String anyInfo) throws Exception {
        List<UserDTO> userDTOList = getSqlSession().selectList("com.wwwy.liuxing.user.dto.UserMapper.criteriaQueryUser", anyInfo);
        logger.info(userDTOList);
        return userDTOList;
    }
}
