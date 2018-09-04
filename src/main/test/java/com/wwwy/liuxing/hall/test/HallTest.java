package com.wwwy.liuxing.hall.test;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hall.dao.IHallDao;
import com.wwwy.liuxing.hall.service.IHallService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 测试根据影院获取影厅信息
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class HallTest {
    private static final Logger logger = Logger.getLogger(HallTest.class);
    @Autowired
    private IHallDao hallDao;
    @Autowired
    private IHallService hallService;

    /**
     * 测试hall的道层
     * 根据电影院与影厅ID获取影厅详情
     */
    @Test
    public void testQueryHallByTheaterIdAndHallId() {
        HallDTO hallDTO = null;
        try {
            hallDTO = hallDao.queryHallByTheaterIdAndHallId(1, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(hallDTO.getHallName());
    }

    /**
     * 测试hall的service层
     * 根据电影院与影厅ID获取影厅详情
     */
    @Test
    public void testHallService() {
        try {
            HallDTO hallDTO = hallService.queryHallByTheaterIdAndHallId("1", "1");
            logger.info("影厅名：" + hallDTO.getHallName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHallSeat() {
        try {
            HallDTO hallDTO = hallService.queryByName("一号IMAX厅");
            logger.info(hallDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert(){
        HallDTO hallDTO = new HallDTO();
        hallDTO.setHallName("lalla");
        hallDTO.setFkTheaterId(3);
        hallDTO.setHallCoordinateX(6);
        hallDTO.setHallCoordinateY(7);
        try {
            Boolean aBoolean = hallDao.insertHall(hallDTO);
            logger.debug(aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHallById(){
        HallDTO hallInfoById = null;
        try {
            hallInfoById = hallDao.getHallInfoById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(hallInfoById);
    }

    @Test
    public void testHallUpdate(){
        HallDTO hallDTO = new HallDTO();
        hallDTO.setHallId(37);
        hallDTO.setHallName("1号IMAX厅");
        hallDTO.setFkTheaterId(2);
        hallDTO.setHallCoordinateX(11);
        hallDTO.setHallCoordinateY(11);
        try {
            Integer integer = hallDao.updateHallInfo(hallDTO);
            logger.info(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testcriteriaQueryHall(){
        try {
            List<HallDTO> hallDTOs = hallDao.criteriaQueryHall("7");
            for (HallDTO h:hallDTOs) {
                logger.info(h);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryAllHall(){
        try {
            PageInfo<HallDTO> hallDTOPageInfo = hallService.queryAllHall(1);
            List<HallDTO> list = hallDTOPageInfo.getList();
            for (HallDTO hallDTO:list){
                logger.info(hallDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testgetBatchDeleteHall(){
        int[] ints = {32};
        try {
            Integer integer = hallDao.tchDeleteHall(ints);
            logger.info(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
