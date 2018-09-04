package com.wwwy.liuxing.cart.test;

import com.sun.xml.internal.txw2.annotation.XmlAttribute;
import com.wwwy.liuxing.cart.dto.CartDTO;
import com.wwwy.liuxing.cart.service.ICartService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class CartTest {
    private Logger logger = Logger.getLogger(CartTest.class);
    @Autowired
    private ICartService cartService;

    @Test
    public void testCase1() {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCinemaName("wanda");
        cartDTO.setHallName("vipHall");
        cartDTO.setMovieName("kongfu");
        cartDTO.setWatchingTime("12:00");
        cartDTO.setSelectedSets("2-3，4-6，3-5");
        System.out.println(cartDTO);
        cartService.saveBookingCart("abc", cartDTO);
        logger.debug("测试结束");
    }

    @Test
    public void testCase2() {
        CartDTO cartDTO = cartService.getBookingCart("13245645433", "红海行动");
        logger.debug(cartDTO.getMovieName());
        logger.debug(cartDTO.getWatchingTime());
        logger.debug(cartDTO.getSelectedSets());
        logger.debug("请求ok");
    }

    @Test
    public void testCase3() {
        List<String> setList = cartService.getSetList("2排6座,3排3座,5排5座,4排8座");
        for (String str : setList) {
            logger.debug(str);
        }
    }
}
