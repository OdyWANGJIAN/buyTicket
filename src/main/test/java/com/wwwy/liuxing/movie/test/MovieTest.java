package com.wwwy.liuxing.movie.test;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.movie.dao.IMovieDao;
import com.wwwy.liuxing.movie.dto.MovieDTO;
import com.wwwy.liuxing.movie.service.IMovieService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 跟电影有关的测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class MovieTest {
    private static final Logger logger = Logger.getLogger(MovieTest.class);
    @Autowired
    private IMovieDao movieDao;

    @Autowired
    private IMovieService movieService;

    /**
     * 测试MovieDao的  getAllMovieByCityName(String cityName)
     */
    @Test
    public void testDaoGetAllMovieByCityName(){
        try {
            List<MovieDTO> dtoList = movieDao.getAllMovieByCityName("武汉");
            for (MovieDTO movie :dtoList) {
                logger.info(movie.getMovieName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 测试MovieService的  getAllMovieByCityName(String cityName)
     */
    @Test
    public void testServiceGetAllMovieByCityName(){
        try {
            List<MovieDTO> movieDTOList = movieService.getAllMovieByCityName("武汉");
            for (MovieDTO movie:movieDTOList) {
                logger.info(movie.getMovieId()+"\t"+movie.getMovieName()+"\t"+movie.getMovieScore()+"\t"+movie.getMovieImg());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGetMovieByCondition(){
        try {
            List<MovieDTO> movieDTOs = movieDao.getMoviesByCondition("动作,冒险,科幻", "",null);
            for (MovieDTO movie:movieDTOs) {
                if (logger.isDebugEnabled()){
                    logger.debug(movie.getMovieName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *测试MovieDao的  getMovieByCityIdAndMovieId(Integer cityId, Integer movieId)
     */
    @Test
    public void testDaoGetMovieByCityIdAndMovieId(){
        try {
            MovieDTO movieDTO = movieDao.getMovieByCityIdAndMovieId(1, 1);
            logger.info(movieDTO.getMovieName()+"\t"+movieDTO.getMovieCountry()+"\t"+movieDTO.getMovieTime()+"\t"+movieDTO.getMovieDate()+"\t"+movieDTO.getMovieType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 测试MovieService的  MovieDTO getMovieByCityIdAndMovieId(Integer cityId,Integer movieId) throws Exception;
     */
    @Test
    public void testServiceGetMovieByCityIdAndMovieId(){
        try {
            MovieDTO movieDTO = movieDao.getMovieByCityIdAndMovieId(1, 1);
            logger.info(movieDTO.getMovieName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * 测试GteMovieInfo的DAO
    * */
    @Test
    public void testGteMovieInfo(){
        try {
            List<MovieDTO> movieInfo = movieDao.getMovieInfo();
            for (MovieDTO m:movieInfo) {
                logger.info(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * test查询所有电影信息并分页
    * */
    @Test
    public void testGetAllmovieInfo(){
        try {
            PageInfo<MovieDTO> allMovieInfo = movieService.getAllMovieInfo(1);
            List<MovieDTO> list = allMovieInfo.getList();
            for (MovieDTO m:list) {
                logger.info("==========================="+m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    * test新增电影信息
    * */
   @Test
    public void testInsert(){
       try {
           MovieDTO movieDTO = new MovieDTO();
           movieDTO.setMovieName("电锯惊魂");
           movieDTO.setMovieDirector("111111111111");
           movieDTO.setMovieCountry("美国");
           movieDTO.setMovieDate("111111111");
           movieDTO.setMovieDetails("11111111111");
           movieDTO.setMovieImg("11111111111");
           movieDTO.setMovieLanguage("1111111111");
           movieDTO.setMoviePreparation("11111111111");
           movieDTO.setMovieTime("1111111111");
           movieDTO.setMovieStar("1111111111111");
           movieDTO.setMovieType("11111111111");
           Integer integer = movieDao.insertMovieInfo(movieDTO);
           logger.info(integer);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }


    /*
    * 修改电影信息
    * */
    @Test
    public void testUpdate(){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(11);
        movieDTO.setMovieName("大萨达");
        movieDTO.setMovieType("asdasd");
        movieDTO.setMovieDirector("dsadasd");
        movieDTO.setMoviePreparation("dsadasd");
        movieDTO.setMovieStar("dsadsad");
        movieDTO.setMovieDetails("dsadas");
        movieDTO.setMovieDate("1111");
        movieDTO.setMovieImg("dsdsdasd");
        movieDTO.setMovieCountry("ewqeqwe");
        try {
            Integer integer = movieDao.upadetaMovieInfo(movieDTO);
            logger.info("======================="+integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    * 通过id查询所有信息
    * */
    @Test
    public void testGetMovieInfoByI(){
        try {
            MovieDTO movieInfoById = movieDao.getMovieInfoById(1);
            logger.info(movieInfoById);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * 通过ID删除电影信息
    * */
    @Test
    public void testDeleteMovieInfoById(){
        try {
            Integer integer = movieDao.deleteMovieInfoById(11);
            logger.info(integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * 条件查询
    * */
    @Test
    public void testCriteriaQueryMovie(){
        try {
            List<MovieDTO> list = movieDao.criteriaQueryMovie("中国");
            for (MovieDTO m:list) {
                logger.info("=========================="+m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
