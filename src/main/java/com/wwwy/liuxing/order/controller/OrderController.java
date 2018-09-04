package com.wwwy.liuxing.order.controller;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.order.dto.OrderDTO;
import com.wwwy.liuxing.order.service.IOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by W1665 on 2018/4/21.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = Logger.getLogger(OrderController.class);

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/all")
    public String queryAll(HttpServletRequest request,ModelMap modelMap){
        String page = request.getParameter("page");
        try {
            PageInfo<OrderDTO> pageInfo = orderService.queryAll(Integer.parseInt(page));
            List<OrderDTO> list = pageInfo.getList();
            logger.debug(list.toString());
            modelMap.addAttribute("page",pageInfo);
            modelMap.put("orderList",list);
            return "hou_order_list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }
    }


    @RequestMapping("/anyInfo")
    public String queryAnyInfo(HttpServletRequest request,ModelMap modelMap){
        String page = request.getParameter("page");
        String anyInfo = request.getParameter("anyInfo");
        try {
            PageInfo<OrderDTO> pageInfo = orderService.queryAnyInfo(Integer.parseInt(page),anyInfo);
            List<OrderDTO> list = pageInfo.getList();
            logger.debug(list.toString());
            modelMap.addAttribute("page",pageInfo);
            modelMap.put("orderList",list);
            return "hou_order_any_list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }
    }
}
