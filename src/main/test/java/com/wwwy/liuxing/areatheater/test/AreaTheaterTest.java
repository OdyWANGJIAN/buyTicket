package com.wwwy.liuxing.areatheater.test;

import com.wwwy.liuxing.arth.dao.IAreaTheaterDAO;
import com.wwwy.liuxing.arth.dto.AreaTheaterDTO;
import com.wwwy.liuxing.arth.service.IAreaTheaterService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by W1665 on 2018/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class AreaTheaterTest {

    @Autowired
    private IAreaTheaterDAO areaTheaterDAO;

    @Autowired
    private IAreaTheaterService areaTheaterService;

    private static final Logger logger = Logger.getLogger(AreaTheaterTest.class);

    @Test
    public void testQueryAll(){
        try {
            List<AreaTheaterDTO> list = areaTheaterDAO.queryAllArea();
            for (AreaTheaterDTO at :
                    list) {
                logger.debug(at.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryById(){
        try {
            AreaTheaterDTO areaTheaterDTO = areaTheaterDAO.queryById(3);
            logger.debug(areaTheaterDTO.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert(){
        AreaTheaterDTO areaTheaterDTO = new AreaTheaterDTO();
        areaTheaterDTO.setFkThId(46);
        areaTheaterDTO.setFkArId(7);
        try {
            Boolean aBoolean = areaTheaterDAO.insertAreaTheater(areaTheaterDTO);
            logger.debug(aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        try {
            Boolean aBoolean = areaTheaterDAO.deleteAreaTheater(47);
            logger.debug(aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        AreaTheaterDTO areaTheaterDTO = new AreaTheaterDTO();
        areaTheaterDTO.setArThId(47);
        areaTheaterDTO.setFkArId(6);
        try {
            Boolean aBoolean = areaTheaterDAO.updateAreaTheater(areaTheaterDTO);
            logger.debug(aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryByAnyInfo(){
        try {
            List<AreaTheaterDTO> areaTheaterDTOs = areaTheaterDAO.queryAreaTheaterByAny("3");
            for (AreaTheaterDTO at :
                    areaTheaterDTOs) {
                logger.debug(at.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDeleteBatch(){
        int areaId[]={47};
        try {
            Boolean aBoolean = areaTheaterDAO.deleteBatchAreas(areaId);
            logger.debug(aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
