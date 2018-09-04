package com.wwwy.liuxing.hallMovie.test;

import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.hallmovie.dao.IHallMovieDao;
import com.wwwy.liuxing.hallmovie.service.IHallMovieService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.List;

/**
 * Created by wanghao on 2018/4/14.
 * 测试HallMovie dao 层
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class HallMovieTest {
    private static final Logger logger = Logger.getLogger(HallMovieTest.class);
    @Autowired
    private IHallMovieDao hallMovieDao;
    @Autowired
    private IHallMovieService hallMovieService;

    /**
     * 测试 
     * 根据城市、影院、电影获取该电影院该电影的最低价格
     */
    @Test
    public void testGetLowestMoviePrice(){
        try {
            HallMovieDTO hallmovie = hallMovieDao.getLowestMoviePrice(1,1,1);
            logger.info(hallmovie.getMoviePrice());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryAll(){
        try {
            List<HallMovieDTO> list = hallMovieDao.queryAll();
            for (HallMovieDTO hm:
                 list) {
                logger.debug(hm.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryById(){
        try {
            HallMovieDTO hallMovieDTO = hallMovieDao.queryById(1);
            logger.debug(hallMovieDTO.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert(){
        HallMovieDTO hallMovieDTO = new HallMovieDTO();
        hallMovieDTO.setFkHallId(1);
        hallMovieDTO.setFkMovieId(2);
        hallMovieDTO.setMovieRuntime("20:20");
        hallMovieDTO.setMoviePrice(30);
        hallMovieDTO.setMovieVersion("2D");
        try {
            Boolean insert = hallMovieDao.insert(hallMovieDTO);
            logger.debug(insert);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        try {
            Boolean delete = hallMovieDao.delete(null);
            logger.debug(delete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        HallMovieDTO hallMovieDTO = new HallMovieDTO();
        hallMovieDTO.setHaMoId(20);
        try {
            Boolean update = hallMovieDao.update(hallMovieDTO);
            logger.debug(update);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryByAny(){
        try {
            List<HallMovieDTO> list = hallMovieDao.queryByAny("暴裂无声");
            for (HallMovieDTO hm:
                 list) {
                logger.debug(hm.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 测试String转换成date格式
     */
    @Test
    public void testQueryPlayingHallMovie(){
        try {
            List<HallMovieDTO> list = hallMovieDao.queryPlayingHallMovie(1, 1, 1);
            for (HallMovieDTO hm:list) {
                String movieRuntime = hm.getMovieRuntime();
//                logger.info(movieRuntime);
                String time = movieRuntime+":00";
                logger.info(time);
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                Date time1 = sdf.parse(time);
                logger.info(time1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testQueryPlayingHallMovie2(){
        try {
            List<HallMovieDTO> list = hallMovieService.queryPlayingHallMovie("1", "4", "8");
            for(HallMovieDTO hallMovieDTO:list){
                logger.info(hallMovieDTO.getHallName()+"\t"+hallMovieDTO.getMovieRuntime()+"\t"+hallMovieDTO.getMoviePrice());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
