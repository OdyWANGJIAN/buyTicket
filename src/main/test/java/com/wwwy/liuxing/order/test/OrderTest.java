package com.wwwy.liuxing.order.test;

import com.wwwy.liuxing.order.dao.IOrderDAO;
import com.wwwy.liuxing.order.dto.OrderDTO;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by W1665 on 2018/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class OrderTest {

    private static final Logger logger = Logger.getLogger(OrderTest.class);

    @Autowired
    private IOrderDAO orderDAO;

    @Test
    public void testQueryAll(){
        try {
            List<OrderDTO> list = orderDAO.queryAll();
            for (OrderDTO order :
                    list) {
                logger.debug(order.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
