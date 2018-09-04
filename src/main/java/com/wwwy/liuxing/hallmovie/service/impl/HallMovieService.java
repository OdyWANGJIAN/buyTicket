package com.wwwy.liuxing.hallmovie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.hall.dao.IHallDao;
import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hallmovie.dao.IHallMovieDao;
import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.hallmovie.service.IHallMovieService;
import com.wwwy.liuxing.movie.dao.IMovieDao;
import com.wwwy.liuxing.movie.dto.MovieDTO;
import com.wwwy.liuxing.movie.service.IMovieService;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/18
 */
@Service
public class HallMovieService implements IHallMovieService {

    private static final Logger logger = Logger.getLogger(HallMovieService.class);

    @Autowired
    private IHallMovieDao hallMovieDao;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private IHallDao hallDAO;
    
    @Override
    public PageInfo<HallMovieDTO> queryAll(Integer page) throws Exception {
        int start= SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
//        开始分页，初始位置，每页大小
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<HallMovieDTO> list = hallMovieDao.queryAll();
        for (HallMovieDTO hm :
                list) {

            HallDTO hallDTO = hallDAO.queryHallById(hm.getFkHallId());
            hm.setHallName(hallDTO.getHallName());
            MovieDTO movieDTO = movieService.queryMovieById(hm.getFkMovieId());
            hm.setMovieName(movieDTO.getMovieName());
        }
        PageInfo<HallMovieDTO> pageInfo = new PageInfo<HallMovieDTO>(list);
        return pageInfo;
    }

    /**
     * 查询某个影厅放映某个电影的场次
     * @param cityId
     * @param theaterId
     * @param movieId
     * @return
     * @throws Exception
     */
    @Override
    public List<HallMovieDTO> queryPlayingHallMovie(String cityId, String theaterId, String movieId) throws Exception {
        int cityid = Integer.parseInt(cityId);
        int theaterid = Integer.parseInt(theaterId);
        int movieid = Integer.parseInt(movieId);
        List<HallMovieDTO> list = hallMovieDao.queryPlayingHallMovie(cityid, theaterid, movieid);
        for(HallMovieDTO hallMovieDTO:list){
            HallDTO hallDTO = hallDAO.queryHallById(hallMovieDTO.getFkHallId());
            hallMovieDTO.setHallName(hallDTO.getHallName());
        }
        return list;
    }

    @Override
    public HallMovieDTO queryById(Integer id) throws Exception {
        return hallMovieDao.queryById(id);
    }

    @Override
    public Boolean insert(HallMovieDTO hallMovieDTO) throws Exception {
        return hallMovieDao.insert(hallMovieDTO);
    }

    @Override
    public Boolean delete(Integer id) throws Exception {
        return hallMovieDao.delete(id);
    }

    @Override
    public Boolean update(HallMovieDTO hallMovieDTO) throws Exception {
        return hallMovieDao.update(hallMovieDTO);
    }

    @Override
    public PageInfo<HallMovieDTO> queryByAny(String anyInfo, Integer page) throws Exception {
        int start= SysConfig.BeforeConfig.PAGE_START;
        if(null==page || page<start){
            page=start;
        }
//        开始分页，初始位置，每页大小
        PageHelper.startPage(page,SysConfig.BeforeConfig.PAGE_SIZE);
        List<HallMovieDTO> list= hallMovieDao.queryByAny(anyInfo);
        for (HallMovieDTO hm :
                list) {
            HallDTO hallDTO = hallDAO.queryHallById(hm.getFkHallId());
            hm.setHallName(hallDTO.getHallName());
            logger.debug(hallDTO.getHallName());
            MovieDTO movieDTO = movieService.queryMovieById(hm.getFkMovieId());
            hm.setMovieName(movieDTO.getMovieName());
        }
        PageInfo<HallMovieDTO> pageInfo = new PageInfo<HallMovieDTO>(list);
        return pageInfo;
    }

    @Override
    public Boolean deleteBatch(int[] haMoId) throws Exception {
        return hallMovieDao.deleteBatchAreas(haMoId);
    }
}
