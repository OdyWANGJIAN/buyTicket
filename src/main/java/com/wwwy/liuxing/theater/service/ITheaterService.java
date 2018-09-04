package com.wwwy.liuxing.theater.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/12.
 */
public interface ITheaterService {
    List<TheaterDTO> queryTheaterByPattern(String pattern) throws Exception;
    /**
     * 根据城市和电影获取放映该电影的电影院名和影院地址
     * （影院最低价格 用另一个sql在hallmovie_mapper.xml中查询每个放映该电影的最低价格）
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    List<TheaterDTO> queryLowestPriceTheaterList(String cityId,String movieId) throws Exception;

    /**
     * 根据城市和电影获取放映该电影的电影院名、影院地址、最低价格
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    Map<TheaterDTO,HallMovieDTO> queryLowestTheaterAndPrice(String cityId, String movieId)throws Exception;


    /**
     * 根据城市和电影获取放映该电影的电影院名、影院地址、
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    List<TheaterDTO> queryLowestPriceTheater(String cityId,String movieId)throws Exception;

    /**
     * 根据城市和电影获取放映该电影的电影院最低价格
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    List<HallMovieDTO> queryLowestPrice(String cityId,String movieId) throws Exception;

    /**
     * 查询所有的影院，并分页
     * @param areaName
     * @param currentPage
     * @return
     * @throws Exception
     */
    PageInfo<TheaterDTO> queryAllTheater(String areaName,Integer currentPage)throws Exception;

      /**
     * 根据id查询某一个影院的信息
     * @param theaterId
     * @return
     * @throws Exception
     */
    TheaterDTO queryTheaterById(Integer theaterId)throws Exception;

    /**
     * 插入新的影院
     * @param theaterDTO
     * @return
     * @throws Exception
     */
    Boolean insertTheater(TheaterDTO theaterDTO)throws Exception;

    /**
     * 根据id删除对应的影院信息
     * @param theaterId
     * @return
     * @throws Exception
     */
    Boolean deleteTheater(Integer theaterId)throws Exception;

    /**
     * 修改对应的影院信息
     * @param theaterDTO
     * @return
     * @throws Exception
     */
    Boolean updateTheater(TheaterDTO theaterDTO)throws Exception;

    /**
     * 根据任意的信息查询
     * @param anyInfo
     * @return
     * @throws Exception
     */
    PageInfo<TheaterDTO> queryTheaterByAny(String anyInfo, Integer page)throws Exception;

    /**
     * 批量删除影院信息
     * @param theaterId
     * @return
     * @throws Exception
     */
    Boolean deleteBatchTheater(int[] theaterId)throws Exception;

    /**
     * 根据名字查询影院
     * @param theaterName
     * @return
     * @throws Exception
     */
    TheaterDTO queryTheaterByName(String theaterName)throws Exception;
}
