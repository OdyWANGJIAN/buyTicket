package com.wwwy.liuxing.hallmovie.service;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/18
 */
@Service
public interface IHallMovieService {

    /**
     * 查询所有信息并分页
     * @param page
     * @return
     * @throws Exception
     */
    PageInfo<HallMovieDTO> queryAll(Integer page)throws Exception;

    /**
     * 查询某个影厅放映某个电影的场次
     * @param cityId
     * @param theaterId
     * @param movieId
     * @return
     * @throws Exception
     */
    List<HallMovieDTO> queryPlayingHallMovie(String cityId, String theaterId, String movieId) throws Exception;

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
     * @param page
     * @return
     * @throws Exception
     */
    PageInfo<HallMovieDTO> queryByAny(String anyInfo,Integer page)throws Exception;

    /**
     * 批量删除影厅信息
     * @param haMoId
     * @return
     * @throws Exception
     */
    Boolean deleteBatch(int[] haMoId)throws Exception;
}
