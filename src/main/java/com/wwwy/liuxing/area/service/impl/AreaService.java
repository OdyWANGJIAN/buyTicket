package com.wwwy.liuxing.area.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dao.IAreaDAO;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import com.wwwy.liuxing.city.dto.CityDTO;
import com.wwwy.liuxing.city.service.ICityService;
import com.wwwy.liuxing.system.SysConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author W1665
 * @date 2018/4/11
 */
@Service
@Transactional
public class AreaService implements IAreaService {

    @Autowired
    private IAreaDAO areaDAO;

    @Autowired
    private ICityService cityService;


    private static final Logger logger = Logger.getLogger(AreaService.class);

    @Override
    public List<AreaDTO> queryAllArea(Integer cityId) throws Exception {
        return areaDAO.queryAll(cityId);
    }

    /**
     * 将地区对应的城市名当做key值，value值为将地区集合封装过后的PageInfo
     * @param cityId
     * @param page
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<AreaDTO> queryAllArea(Integer cityId, Integer page)throws Exception {
        logger.debug("currentPage::::"+page);
        int start=SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
//        开始分页，初始位置，每页大小
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<AreaDTO> areaDTOList = areaDAO.queryAll(cityId);
        for (AreaDTO area :
                areaDTOList) {
            CityDTO cityDTO = cityService.queryCityById(area.getFkCityId());
            area.setCityName(cityDTO.getCityName());
        }
        PageInfo<AreaDTO> pageInfo = new PageInfo<AreaDTO>(areaDTOList);
        logger.debug("pageInfo"+pageInfo);
        return pageInfo;
    }

    @Override
    public AreaDTO queryAreaById(Integer areaId) throws Exception {
        return areaDAO.queryAreaById(areaId);
    }

    @Override
    public Boolean insertArea(AreaDTO areaDTO)throws Exception {
        return areaDAO.insertArea(areaDTO);
    }

    @Override
    public Boolean deleteArea(Integer areaId)throws Exception {
        return areaDAO.deleteArea(areaId);
    }

    @Override
    public Boolean updateArea(AreaDTO areaDTO)throws Exception {
        return areaDAO.updateArea(areaDTO);
    }

    @Override
    public PageInfo<AreaDTO> queryAreaByAny(String anyInfo,Integer page) throws Exception {
        logger.debug("currentPage::::"+page);
        int start=SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<AreaDTO> list = areaDAO.queryAreaByAny(anyInfo);
        for (AreaDTO area :
                list) {
            CityDTO cityDTO = cityService.queryCityById(area.getFkCityId());
            area.setCityName(cityDTO.getCityName());
        }
        PageInfo<AreaDTO> pageInfo = new PageInfo<AreaDTO>(list);
        return pageInfo;
    }

    @Override
    public Boolean deleteBatchAreas(int[] areaId) throws Exception {
        return areaDAO.deleteBatchAreas(areaId);
    }


}
