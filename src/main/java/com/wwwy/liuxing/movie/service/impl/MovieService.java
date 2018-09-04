package com.wwwy.liuxing.movie.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.movie.dao.IMovieDao;
import com.wwwy.liuxing.movie.dto.MovieDTO;
import com.wwwy.liuxing.movie.service.IMovieService;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.user.dto.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 跟电影有感的service的实体类
 */
@Service
public class MovieService implements IMovieService{
    @Autowired
    private IMovieDao movieDao;


    private static final Logger logger = Logger.getLogger(MovieService.class);

    /**
     * 根据城市名查询所有电影id，电影名，电影图片，电影评分,返回的是带有这四个属性值得MovieDTO对象集合
     *
     * @param cityName
     * @return
     * @throws Exception
     */
    @Override
    public List<MovieDTO> getAllMovieByCityName(String cityName) throws Exception {
        List<MovieDTO> movieDTOList = movieDao.getAllMovieByCityName(cityName);
        return movieDTOList;
    }

    @Override
    public MovieDTO getMovieByCityIdAndMovieId(String cityId, String movieId) throws Exception {
        int cityid = Integer.parseInt(cityId);
        int movieid = Integer.parseInt(movieId);
        MovieDTO movieDTO = movieDao.getMovieByCityIdAndMovieId(cityid, movieid);
        return movieDTO;
    }

    @Override
    public MovieDTO queryMovieById(Integer id) throws Exception {
        return movieDao.queryMovieById(id);
    }

    /**
     * 根据传入的条件动态查询符合的一个或多个条件的电影集合
     *
     * @param type    影片类型
     * @param country 影片国家
     * @param date    影片上映时间
     * @return
     * @throws Exception
     */
    @Override
    public List<MovieDTO> getMoviesByCondition(String type, String country, String date) throws Exception {
        return movieDao.getMoviesByCondition(type, country, date);
    }


    /*
    * 后台增加电影信息
    * */
    @Override
    public boolean insertMovieInfo(MovieDTO movieDTO) throws Exception {
        Integer integer = movieDao.insertMovieInfo(movieDTO);
        if (integer>0){
            return true;
        }
        return false;
    }

    /*
    * 后台查询所有电影信息并分页
    * */
    @Override
    public PageInfo<MovieDTO> getAllMovieInfo(Integer page) throws Exception {
        Integer pageStart = SysConfig.BeforeConfig.PAGE_START;
        if (page==null||page<pageStart){
            page=pageStart;
        }
        PageHelper.startPage(page, SysConfig.BeforeConfig.PAGE_SIZE);
        List<MovieDTO> movieDTOList = movieDao.getMovieInfo();
        logger.info("................."+movieDTOList);
        PageInfo<MovieDTO> movieDTOPageInfo = new PageInfo<MovieDTO>(movieDTOList);
        return movieDTOPageInfo;
    }


    /*
   * 后台修改电影信息
   * */
    @Override
    public boolean updateMovieInfo(MovieDTO movieDTO) throws Exception {
        Integer integer = movieDao.upadetaMovieInfo(movieDTO);
        if (integer>0) {
            return true;
        }
        return false;
    }

    /*
    * 通过ID获取电影信息
    * */
    @Override
    public MovieDTO getMovieInfoById(Integer movieId) throws Exception {
        return movieDao.getMovieInfoById(movieId);
    }

    /*
    * 通过ID删除电影信息
    * */
    @Override
    public boolean deleteMovieInfoById(Integer movieId) throws Exception {
        Integer integer = movieDao.deleteMovieInfoById(movieId);
        if (integer>0){
            return true;
        }
        return false;
    }

    /*
    *  条件查询电影信息
    * */
    @Override
    public PageInfo<MovieDTO> criteriaQueryMovie(Integer page,String anyInfo) throws Exception {
        Integer pageStart = SysConfig.BeforeConfig.PAGE_START;
        if (page==null||page<pageStart){
            page=pageStart;
        }
        PageHelper.startPage(page, SysConfig.BeforeConfig.PAGE_SIZE);
        List<MovieDTO> movieDTOList = movieDao.criteriaQueryMovie(anyInfo);
        PageInfo<MovieDTO> movieDTOPageInfo = new PageInfo<MovieDTO>(movieDTOList);
        return movieDTOPageInfo;
    }
}
