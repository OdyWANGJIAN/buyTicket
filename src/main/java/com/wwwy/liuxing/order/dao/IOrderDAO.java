package com.wwwy.liuxing.order.dao;

import com.wwwy.liuxing.order.dto.OrderDTO;

import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/21
 */
public interface IOrderDAO {

    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    List<OrderDTO> queryAll()throws Exception;

    /**
     * 根据任意信息查询对应的订单信息
     * @param anyInfo
     * @return
     * @throws Exception
     */
    List<OrderDTO> queryAny(String anyInfo)throws Exception;

}
