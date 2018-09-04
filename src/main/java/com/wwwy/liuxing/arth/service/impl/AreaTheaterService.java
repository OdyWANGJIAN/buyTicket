package com.wwwy.liuxing.arth.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dao.IAreaDAO;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.arth.dao.IAreaTheaterDAO;
import com.wwwy.liuxing.arth.dto.AreaTheaterDTO;
import com.wwwy.liuxing.arth.service.IAreaTheaterService;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by W1665 on 2018/4/16.
 */
@Service
public class AreaTheaterService implements IAreaTheaterService{

    private static final Logger logger = Logger.getLogger(AreaTheaterService.class);
    @Autowired
    private IAreaTheaterDAO areaTheaterDAO;

    @Autowired
    private IAreaDAO areaDAO;

    @Autowired
    private ITheaterDAO theaterDAO;

    @Override
    public PageInfo<AreaTheaterDTO> queryAll(Integer page) throws Exception {
        logger.debug("currentPage::::"+page);
        int start= SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
//        开始分页，初始位置，每页大小
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<AreaTheaterDTO> list = areaTheaterDAO.queryAllArea();
        for (AreaTheaterDTO at :
                list) {
            AreaDTO areaDTO = areaDAO.queryAreaById(at.getFkArId());
            at.setAreaName(areaDTO.getAreaName());
            TheaterDTO theaterDTO = theaterDAO.queryTheaterById(at.getFkThId());
            at.setTheaterName(theaterDTO.getTheaterName());
        }
        PageInfo<AreaTheaterDTO> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public AreaTheaterDTO queryById(Integer id) throws Exception {
        return areaTheaterDAO.queryById(id);
    }


    @Override
    public Boolean insertAreaTheater(AreaTheaterDTO areaTheaterDTO) throws Exception {
        return areaTheaterDAO.insertAreaTheater(areaTheaterDTO);
    }

    @Override
    public Boolean deleteAreaTheater(Integer id) throws Exception {
        return areaTheaterDAO.deleteAreaTheater(id);
    }

    @Override
    public Boolean updateAreaTheater(AreaTheaterDTO areaTheaterDTO) throws Exception {
        return areaTheaterDAO.updateAreaTheater(areaTheaterDTO);
    }

    @Override
    public PageInfo<AreaTheaterDTO> queryAreaTheaterByAny(String anyInfo,Integer page) throws Exception {
        logger.debug("currentPage::::"+page);
        int start= SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
//        开始分页，初始位置，每页大小
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<AreaTheaterDTO> list = areaTheaterDAO.queryAreaTheaterByAny(anyInfo);
        for (AreaTheaterDTO at :
                list) {
            AreaDTO areaDTO = areaDAO.queryAreaById(at.getFkArId());
            logger.debug(areaDTO.getAreaName());
            at.setAreaName(areaDTO.getAreaName());
            TheaterDTO theaterDTO = theaterDAO.queryTheaterById(at.getFkThId());
            at.setTheaterName(theaterDTO.getTheaterName());
        }
        PageInfo<AreaTheaterDTO> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Boolean deleteBatchAreas(int[] areaId) throws Exception {
        return areaTheaterDAO.deleteBatchAreas(areaId) ;
    }
}
