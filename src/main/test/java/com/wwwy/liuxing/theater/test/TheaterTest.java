package com.wwwy.liuxing.theater.test;

import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.hallmovie.dao.IHallMovieDao;
import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import com.wwwy.liuxing.theater.service.ITheaterService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2018/4/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class TheaterTest {
    private static final Logger logger = Logger.getLogger(TheaterTest.class);
    @Autowired
    private IHallMovieDao hallMovieDao;
    @Autowired
    private ITheaterDAO theaterDAO;
    @Autowired
    private ITheaterService theaterService;
    @Test
    public void testCase1(){
        try {
            List<TheaterDTO> theaterDTOs = theaterService.queryTheaterByPattern("中");
            for (TheaterDTO theater:theaterDTOs) {
                if (logger.isInfoEnabled()){
                    logger.info(theater.getTheaterName()+"=========="+theater.getTheaterAddress());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试 dao层的List<TheaterDTO> queryLowestPriceTheaterList(Integer cityId,Integer movieId) throws Exception;
     */
    @Test
    public void testDaoQueryLowestPriceTheaterList(){
        try {
            List<TheaterDTO> theaterDTOs = theaterDAO.queryLowestPriceTheaterList(1, 1);
            for(TheaterDTO th:theaterDTOs){
                logger.info(th.getTheaterName()+"\t"+th.getTheaterAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * /**
     * 测试 service 层的List<TheaterDTO> queryLowestPriceTheaterList(Integer cityId,Integer movieId) throws Exception;
     */
    @Test
    public void testServiceQueryLowestPriceTheaterList(){
        try {
            List<TheaterDTO> theaterDTOList = theaterService.queryLowestPriceTheaterList("1", "1");
            for (TheaterDTO th:theaterDTOList) {
                logger.info(th.getTheaterId()+"\t"+th.getTheaterName()+"\t"+th.getTheaterAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试 service   根据城市和电影获取放映该电影的电影院名、影院地址、最低价格
     * Map<TheaterDTO,HallMovieDTO> queryLowestTheaterAndPrice(String cityId, String movieId)throws Exception
     */
    @Test
    public void testServiceQueryLowestTheaterAndPrice(){
        try {
            Map<TheaterDTO, HallMovieDTO> map = theaterService.queryLowestTheaterAndPrice("1", "1");
            Set<TheaterDTO> set = map.keySet();
            for (TheaterDTO theater:set) {
                HallMovieDTO hallMovieDTO = hallMovieDao.getLowestMoviePrice(1, theater.getTheaterId(), 1);
                logger.info(theater.getTheaterId()+"\t"+theater.getTheaterName()
                        +"\t"+"\t"+theater.getTheaterAddress()+"\t"+hallMovieDTO.getMoviePrice());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取最低价格的影院
     */
    @Test
    public void testQueryLowestPriceTheater(){
        try {
            List<TheaterDTO> theaterList = theaterService.queryLowestPriceTheater("1", "1");
            for (TheaterDTO theater:theaterList) {
                logger.info(theater.getTheaterId()+"\t"+theater.getTheaterName()+"\t"+theater.getTheaterAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testQueryLowestPrice(){
        try {
            List<HallMovieDTO> hallMovieList = theaterService.queryLowestPrice("1", "1");
            for (HallMovieDTO hallmovie:hallMovieList) {
                logger.info(hallmovie.getMoviePrice());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testQueryAllTheaterByAreaId(){
        try {
            List<TheaterDTO> list = theaterDAO.queryAllTheater("江岸区");
            for (TheaterDTO theater :
                    list) {
                logger.debug(theater.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testInsertTheater(){
        TheaterDTO theaterDTO = new TheaterDTO();
        theaterDTO.setTheaterName("lala");
        theaterDTO.setTheaterAddress("lala");
        theaterDTO.setTheaterPhone("0123");
        theaterDTO.setTheaterLatitude("123");
        theaterDTO.setTheaterLongitude("223");
        Boolean aBoolean = null;
        try {
            aBoolean = theaterDAO.insertTheater(theaterDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug(aBoolean);
    }

    @Test
    public void testDeleteTheater(){
        try {
            Boolean aBoolean = theaterDAO.deleteTheater(47);
            logger.debug(aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        TheaterDTO theaterDTO = new TheaterDTO();
        theaterDTO.setTheaterId(42);
        theaterDTO.setTheaterName("武汉魔影国际");
        try {
            Boolean aBoolean = theaterDAO.updateTheater(theaterDTO);
            logger.debug(aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryByAnyInfo(){
        try {
            List<TheaterDTO> list = theaterDAO.queryTheaterByAny("影院");
            for (TheaterDTO theater :
                    list) {
                logger.debug(theater.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteBatch(){
        int theaters[]={46};
        try {
            Boolean aBoolean = theaterDAO.deleteBatchTheater(theaters);
            logger.debug(aBoolean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryByName(){
        try {
            TheaterDTO theaterDTO = theaterDAO.queryTheaterByName("武汉恒大影城");
            logger.debug(theaterDTO.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
