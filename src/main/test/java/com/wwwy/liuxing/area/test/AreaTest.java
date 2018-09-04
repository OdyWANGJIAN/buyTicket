package com.wwwy.liuxing.area.test;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dao.IAreaDAO;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.reflect.generics.reflectiveObjects.LazyReflectiveObjectGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by W1665 on 2018/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class AreaTest {

    private static final Logger logger = Logger.getLogger(AreaTest.class);

    @Autowired
    private IAreaDAO areaDAO;

    @Autowired
    private IAreaService areaService;

    @Test
    public void testQueryAllAreaByDAO(){
        List<AreaDTO> list = null;
        try {
            Map<String, List<AreaDTO>> map = (Map<String, List<AreaDTO>>) areaDAO.queryAllArea(1);
            for (List<AreaDTO> area :
                    map.values()) {
                for (AreaDTO ar :
                        area) {
                    logger.debug(ar.toString());
                }
                logger.debug(area.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   @Test
    public void testQueryAllAreaByService(){
       PageInfo<AreaDTO> list = null;
       try {
           Map<String, PageInfo<AreaDTO>> map = (Map<String, PageInfo<AreaDTO>>) areaService.queryAllArea(1, 1);
           for (PageInfo area :
                   map.values()) {
               logger.debug(area.toString());
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

    @Test
    public void testInsertArea(){
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setAreaName("nih");
        areaDTO.setFkCityId(1);
        Boolean aBoolean = null;
        try {
            aBoolean = areaDAO.insertArea(areaDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(aBoolean);
    }

    @Test
    public void testDelete(){
        Boolean aBoolean = null;
        try {
            aBoolean = areaDAO.deleteArea(15);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(aBoolean);
    }

    @Test
    public void testUpdate(){
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setAreaId(16);
        areaDTO.setAreaName("hah");
        Boolean aBoolean = null;
        try {
            aBoolean = areaDAO.updateArea(areaDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(aBoolean);
    }

    @Test
    public void testQueryById(){
        try {
            AreaDTO areaDTO = areaDAO.queryAreaById(1);
            logger.debug(areaDTO.getAreaName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testQueryByAny(){
        try {
            List<AreaDTO> areaDTOs = areaDAO.queryAreaByAny("1");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryByAnyService(){
        try {
            areaService.queryAreaByAny("蔡甸区", null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteBatchAreas(){
        int[] arrys={20,21};
        try {
            Boolean aBoolean = areaDAO.deleteBatchAreas(arrys);
            logger.debug(aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        String ids="1,2,3,4,5";
        String[] idStr= StringUtils.split(ids,",");
        for (String STR :
                idStr) {
            logger.debug(STR);
        }
        logger.debug(".......idStr"+idStr.toString());
        int[] areaIds = Arrays.stream(idStr).mapToInt(Integer::valueOf).toArray();
        logger.debug(".........areaIds"+areaIds.toString());
        logger.debug(areaIds.length);
    }

}
