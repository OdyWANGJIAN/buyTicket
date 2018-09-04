package com.wwwy.liuxing.arth.dao;

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
public interface IAreaTheaterDAO {

    /**
     * 查询所有的地区和影院关联的记录并分页
     * @return
     * @throws Exception
     */
    List<AreaTheaterDTO> queryAllArea()throws Exception;

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
     * 根据任何信息查找地区信息
     * @param anyInfo
     * @return
     * @throws Exception
     */
    List<AreaTheaterDTO>  queryAreaTheaterByAny(String anyInfo)throws Exception;

    /**
     * 批量删除地区信息
     * @param areaId
     * @return
     * @throws Exception
     */
    Boolean deleteBatchAreas(int[] areaId)throws Exception;
}
