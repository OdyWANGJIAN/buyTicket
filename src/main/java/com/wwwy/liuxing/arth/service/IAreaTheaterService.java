package com.wwwy.liuxing.arth.service;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.arth.dto.AreaTheaterDTO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;

import java.util.List;
import java.util.Map;

/**
 *
 * @author W1665
 * @date 2018/4/16
 */
public interface IAreaTheaterService {

    /**
     * 查询所有的地区管理影院信息，并分页
     * @param currentPage
     * @return
     * @throws Exception
     */
    PageInfo<AreaTheaterDTO> queryAll(Integer currentPage)throws Exception;

    /**
     * 根据id查询对应的信息
     * @param id
     * @return
     * @throws Exception
     */
    AreaTheaterDTO queryById(Integer id)throws Exception;

    /**
     * 插入新的信息
     * @param areaTheaterDTO
     * @return
     */
    Boolean insertAreaTheater(AreaTheaterDTO areaTheaterDTO)throws Exception;

    /**
     * 根据地区id删除对应的信息
     * @param areaId
     * @return
     */
    Boolean deleteAreaTheater(Integer areaId)throws Exception;

    /**
     * 根据地区id修改对应的信息
     * @param areaTheaterDTO
     * @return
     */
    Boolean updateAreaTheater(AreaTheaterDTO areaTheaterDTO)throws Exception;

    /**
     * 根据任何信息查找对应信息
     * @param anyInfo
     * @param page
     * @return
     * @throws Exception
     */
    PageInfo<AreaTheaterDTO>  queryAreaTheaterByAny(String anyInfo,Integer page)throws Exception;

    /**
     * 批量删除地区信息
     * @param areaId
     * @return
     * @throws Exception
     */
    Boolean deleteBatchAreas(int[] areaId)throws Exception;
}
