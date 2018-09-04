package com.wwwy.liuxing.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.wwwy.liuxing.order.dao.IOrderDAO;
import com.wwwy.liuxing.order.dto.OrderDTO;
import com.wwwy.liuxing.order.service.IOrderService;
import com.wwwy.liuxing.system.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by W1665 on 2018/4/21.
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDAO orderDAO;

    @Override
    public PageInfo<OrderDTO> queryAll(Integer page) throws Exception {
        int start= SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
//        开始分页，初始位置，每页大小
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<OrderDTO> list = orderDAO.queryAll();
        PageInfo<OrderDTO> pageInfo = new PageInfo<OrderDTO>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<OrderDTO> queryAnyInfo(Integer page, String anyInfo) throws Exception {
        int start= SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
//        开始分页，初始位置，每页大小
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<OrderDTO> list = orderDAO.queryAny(anyInfo);
        PageInfo<OrderDTO> pageInfo = new PageInfo<OrderDTO>(list);
        return pageInfo;
    }
}
