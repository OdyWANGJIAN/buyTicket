package com.wwwy.liuxing.hallmovie.dao;

import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;

import java.util.List;

/**
 * Created by wanghao on 2018/4/14.
 * 与影厅电影有关的dao接口类
 */
public interface IHallMovieDao {
    /**
     * 根据城市、影院、电影获取该电影院该电影的最低价格
     * @param cityId
     * @param theaterId
     * @param movieId
     * @return
     * @throws Exception
     */
    HallMovieDTO getLowestMoviePrice(Integer cityId,Integer theaterId,Integer movieId)throws Exception;

    /**
     * 查询所有的影厅影片关联信息
     * @return
     * @throws Exception
     */
    List<HallMovieDTO> queryAll()throws Exception;

    /**
     * 查询某个影厅放映某个电影的场次
     * @param cityId
     * @param theaterId
     * @param movieId
     * @return
     * @throws Exception
     */
    List<HallMovieDTO> queryPlayingHallMovie(Integer cityId,Integer theaterId,Integer movieId)throws Exception;

    /**
     * 根据id查询对象
     * @param id
     * @return
     * @throws Exception
     */
    HallMovieDTO queryById(Integer id)throws Exception;

    /**
     * 插入一条新的信息
     * @return
     * @throws Exception
     */
    Boolean insert(HallMovieDTO hallMovieDTO)throws Exception;

    /**
     * 根据id删除对应信息
     * @param id
     * @return
     * @throws Exception
     */
    Boolean delete(Integer id)throws Exception;

    /**
     * 修改相应的信息
     * @param hallMovieDTO
     * @return
     * @throws Exception
     */
    Boolean update(HallMovieDTO hallMovieDTO)throws Exception;


    /**
     * 根据任意信息查询
     * @param anyInfo
     * @return
     * @throws Exception
     */
    List<HallMovieDTO> queryByAny(String anyInfo)throws Exception;

    /**
     * 批量删除影厅信息
     * @param haMoId
     * @return
     * @throws Exception
     */
    Boolean deleteBatchAreas(int[] haMoId)throws Exception;
}
