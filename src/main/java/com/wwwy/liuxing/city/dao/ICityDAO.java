package com.wwwy.liuxing.city.dao;

import com.wwwy.liuxing.city.dto.CityDTO;

import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/14
 */
public interface ICityDAO {

    /**
     * 根据城市id来查询城市对象
     * @param cityId
     * @return
     */
    CityDTO queryCityById(Integer cityId)throws Exception;

    /**
     * 查询所有的城市
     * @return
     */
    List<CityDTO> queryAllCity()throws Exception;

    /**
     * 根据城市名称查询城市
     * @param cityName
     * @return
     */
    CityDTO queryCityByName(String cityName)throws Exception;
}
