package com.wwwy.liuxing.order.dao.impl;

import com.wwwy.liuxing.order.dao.IOrderDAO;
import com.wwwy.liuxing.order.dto.OrderDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by W1665 on 2018/4/21.
 */
@Repository
public class OrderDAO extends SqlSessionDaoSupport implements IOrderDAO {


    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public List<OrderDTO> queryAll() throws Exception {
        List<OrderDTO> list = getSqlSession().selectList("com.wwwy.liuxin.order.dto.OrderMapper.queryAll");
        return list;
    }

    @Override
    public List<OrderDTO> queryAny(String anyInfo) throws Exception {
        List<OrderDTO> list = getSqlSession().selectList("com.wwwy.liuxin.order.dto.OrderMapper.queryAny", anyInfo);
        return list;
    }
}
