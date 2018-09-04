package com.wwwy.liuxing.movie.dao;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.movie.dto.MovieDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 跟电影有关的dao层接口类
 */
@Repository
public interface IMovieDao {
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
     * 根据城市ID和电影ID获得一个电影信息
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    MovieDTO getMovieByCityIdAndMovieId(Integer cityId,Integer movieId) throws Exception;

    /**
     * 根据id查询电影
     * @param id
     * @return
     * @throws Exception
     */
    MovieDTO queryMovieById(Integer id)throws Exception;

     /*
     * 查询所有电影信息
     * */
    List<MovieDTO> getMovieInfo()throws Exception;

    /*
    * 增加电影信息
    * */
    Integer insertMovieInfo(MovieDTO movieDTO)throws Exception;

    /*
    * 修改电影信息
    * */
    Integer upadetaMovieInfo(MovieDTO movieDTO)throws Exception;

    /*
    * 通过电影ID获取电影信息
    * */
    MovieDTO getMovieInfoById(Integer moiveId)throws Exception;

    /*
    * 通过ID删除电影信息
    * */
    Integer deleteMovieInfoById(Integer moiveId)throws Exception;

    /*
    *条件查询电影信息
    * */
    List<MovieDTO> criteriaQueryMovie(String anyInfo)throws Exception;
}
