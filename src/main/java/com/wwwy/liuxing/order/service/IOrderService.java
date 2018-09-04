package com.wwwy.liuxing.order.service;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.order.dto.OrderDTO;

import java.util.List;

/**
 * Created by W1665 on 2018/4/21.
 */
public interface IOrderService {

    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    PageInfo<OrderDTO> queryAll(Integer page)throws Exception;

    /**
     * 根据任意信息查询订单，并分页
     * @param page
     * @param anyInfo
     * @return
     * @throws Exception
     */
    PageInfo<OrderDTO> queryAnyInfo(Integer page,String anyInfo)throws Exception;
}
