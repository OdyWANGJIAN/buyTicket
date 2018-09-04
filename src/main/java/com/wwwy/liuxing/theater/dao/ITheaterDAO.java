package com.wwwy.liuxing.theater.dao;

import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;

import java.util.List;

/**
 * Created by Administrator on 2018/4/12.
 */
public interface ITheaterDAO {
    List<TheaterDTO> queryTheaterByPattern(String pattern) throws Exception;

    /**
     * 根据城市和电影获取放映该电影的电影院名和影院地址
     * （影院最低价格 用另一个sql在hallmovie_mapper.xml中查询每个放映该电影的最低价格）
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    List<TheaterDTO> queryLowestPriceTheaterList(Integer cityId,Integer movieId) throws Exception;



    /**
     * 查询所有的影院，返回一个list集合
     * @param areaName
     * @return
     * @throws Exception
     */
    List<TheaterDTO> queryAllTheater(String areaName)throws Exception;

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
    List<TheaterDTO> queryTheaterByAny(String anyInfo)throws Exception;

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
