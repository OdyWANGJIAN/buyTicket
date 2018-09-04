package com.wwwy.liuxing.movie.service;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.movie.dto.MovieDTO;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 跟电影有关的service接口类
 */
public interface IMovieService {
    /**
     * 根据城市名查询所有电影id，电影名，电影图片，电影评分,返回的是带有这四个属性值得MovieDTO对象集合
     *
     * @param cityName
     * @return
     * @throws Exception
     */
    List<MovieDTO> getAllMovieByCityName(String cityName) throws Exception;

    /**
     * 根据传入的条件动态查询符合的一个或多个条件的电影集合
     *
     * @param type    影片类型
     * @param country 影片国家
     * @param date    影片上映时间
     * @return
     * @throws Exception
     */
    List<MovieDTO> getMoviesByCondition(String type, String country, String date) throws Exception;

    /**
     * 根据城市和电影获取放映该电影详情
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    MovieDTO getMovieByCityIdAndMovieId(String cityId,String movieId) throws Exception;


    /**
     * 根据id查询电影
     * @param id
     * @return
     * @throws Exception
     */
    MovieDTO queryMovieById(Integer id)throws Exception;


    /*
    * 后台增加电影信息
    * */
    boolean insertMovieInfo(MovieDTO movieDTO)throws Exception;

    /*
    * 后台查询电影所有信息
    * */
    PageInfo<MovieDTO> getAllMovieInfo(Integer page)throws Exception;

    /*
    * 后台更改电影信息
    * */
    boolean updateMovieInfo(MovieDTO movieDTO)throws Exception;

    /*
    * 后台通过ID获取电影信息
    * */
    MovieDTO getMovieInfoById(Integer movieId)throws Exception;


    /*
    * 通过ID删除电影信息
    * */
    boolean deleteMovieInfoById(Integer movieId)throws Exception;

    /*
    * 条件查询电影信息
    * */
    PageInfo<MovieDTO> criteriaQueryMovie(Integer page,String anyInfo)throws Exception;

}
