package com.wwwy.liuxing.city.service.impl;

import com.wwwy.liuxing.city.dao.ICityDAO;
import com.wwwy.liuxing.city.dto.CityDTO;
import com.wwwy.liuxing.city.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/14
 */
@Service
public class CityService implements ICityService {

    @Autowired
    private ICityDAO cityDAO;

    @Override
    public CityDTO queryCityById(Integer cityId) throws Exception{
        return cityDAO.queryCityById(cityId);
    }

    @Override
    public List<CityDTO> queryAllCity()throws Exception {
        return cityDAO.queryAllCity();
    }

    @Override
    public CityDTO queryCityByName(String cityName)throws Exception {
        return cityDAO.queryCityByName(cityName);
    }
}
