package com.wwwy.liuxing.hall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hall.dao.IHallDao;
import com.wwwy.liuxing.hall.service.IHallService;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 */
@Service
public class HallService implements IHallService {
    @Autowired
    private IHallDao hallDao;

    @Autowired
    private ITheaterDAO theaterDAO;

    private static final Logger logger = Logger.getLogger(HallService.class);

    /**
     * 根据影院id和影厅id获取影厅详细信息（座位信息）
     * @param theaterId
     * @param hallId
     * @return
     * @throws Exception
     */
    @Override
    public HallDTO queryHallByTheaterIdAndHallId(String theaterId, String hallId) throws Exception {
        int theaterid = Integer.parseInt(theaterId);
        int hallid = Integer.parseInt(hallId);
        HallDTO hallDTO = hallDao.queryHallByTheaterIdAndHallId(theaterid, hallid);
        return hallDTO;
    }

    @Override
    public PageInfo<HallDTO> queryAllHall(Integer page) throws Exception {
        logger.debug("currentPage::::"+page);
        int start= SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
//        开始分页，初始位置，每页大小
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<HallDTO> list = hallDao.queryAllHall();
        logger.info("-------------------------------"+list.toString());
        for (HallDTO hallDTO:list){
            Integer fkTheaterId = hallDTO.getFkTheaterId();
            TheaterDTO theaterDTO = theaterDAO.queryTheaterById(fkTheaterId);
            String theaterName = theaterDTO.getTheaterName();
            logger.info(theaterName);
            logger.info(hallDTO.getTheaterName());
            hallDTO.setTheaterName(theaterName);
            logger.info("========================="+hallDTO.getTheaterName());
        }
        logger.info("+++++++++++++++++++++="+list.toString());
        PageInfo<HallDTO> pageInfo = new PageInfo<HallDTO>(list);
        return pageInfo;
    }

    @Override
    public HallDTO queryHallById(Integer id) throws Exception {
        return hallDao.queryHallById(id);
    }

    @Override
    public Boolean insertHall(HallDTO hallDTO) throws Exception {
        return hallDao.insertHall(hallDTO);
    }

    @Override
    public Boolean deleteHall(Integer hallId) throws Exception {
        return hallDao.deleteHall(hallId);
    }

    @Override
    public HallDTO getHallInfoById(Integer hallId) throws Exception {
        TheaterDTO theaterDTO = theaterDAO.queryTheaterById(hallId);
        String theaterName = theaterDTO.getTheaterName();
        HallDTO hallInfoById = hallDao.getHallInfoById(hallId);
        hallInfoById.setTheaterName(theaterName);
        logger.info("hallInfoById======================="+hallInfoById);
        return hallInfoById;
    }

    @Override
    public boolean updateHallInfoById(HallDTO hallDTO) throws Exception {
        Integer integer = hallDao.updateHallInfo(hallDTO);
        if (integer>0){
            return true;
        }
        return false;
    }

    @Override
    public PageInfo<HallDTO> criteriaQueryHall(Integer page, String anyInfo) throws Exception {
        Integer pageStart = SysConfig.BeforeConfig.PAGE_START;
        if (page==null||page<pageStart){
            page=pageStart;
        }
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<HallDTO> hallDTOs = hallDao.criteriaQueryHall(anyInfo);
        for (HallDTO hallDTO:hallDTOs){
            Integer fkTheaterId = hallDTO.getFkTheaterId();
            TheaterDTO theaterDTO = theaterDAO.queryTheaterById(fkTheaterId);
            String theaterName = theaterDTO.getTheaterName();
            logger.info(hallDTO.getTheaterName());
            hallDTO.setTheaterName(theaterName);
            logger.info("========================="+hallDTO.getTheaterName());
        }
        PageInfo<HallDTO> hallDTOPageInfo = new PageInfo<>(hallDTOs);
        return hallDTOPageInfo;
    }

    @Override
    public boolean tchDeleteHall(int[] hall) throws Exception {
        Integer integer = hallDao.tchDeleteHall(hall);
        if (integer>0){
            return true;
        }
        return false;
    }

    @Override
    public HallDTO queryByName(String name) throws Exception {
        return hallDao.queryByName(name);
    }
}
