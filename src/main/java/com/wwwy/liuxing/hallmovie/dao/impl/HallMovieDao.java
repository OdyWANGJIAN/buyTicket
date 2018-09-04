package com.wwwy.liuxing.hallmovie.dao.impl;

import com.wwwy.liuxing.hallmovie.dao.IHallMovieDao;
import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.system.SysConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wanghao on 2018/4/14.
 */
@Repository
public class HallMovieDao extends SqlSessionDaoSupport implements IHallMovieDao {
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 根据城市、影院、电影获取该电影院该电影的最低价格
     * @param cityId
     * @param theaterId
     * @param movieId
     * @return
     * @throws Exception
     */
    @Override
    public HallMovieDTO getLowestMoviePrice(Integer cityId, Integer theaterId, Integer movieId) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("cityId",cityId);
        map.put("theaterId",theaterId);
        map.put("movieId",movieId);
        HallMovieDTO hallMovieDTO = getSqlSession().selectOne("com.wwwy.liuxing.hallmovie.dto.HallMovieMapper.queryLowestMoviePriceList", map);
        return hallMovieDTO;
    }

    @Override
    public List<HallMovieDTO> queryAll() throws Exception {
        List<HallMovieDTO> list = getSqlSession().selectList("com.wwwy.liuxing.hallmovie.dto.HallMovieMapper.queryAll");
        return list;
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
    public List<HallMovieDTO> queryPlayingHallMovie(Integer cityId, Integer theaterId, Integer movieId) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("cityId",cityId);
        map.put("theaterId",theaterId);
        map.put("movieId",movieId);
        List<HallMovieDTO> hallMovieList = getSqlSession().selectList("com.wwwy.liuxing.hallmovie.dto.HallMovieMapper.queryPlayingHallMovie", map);
        return hallMovieList;
    }

    @Override
    public HallMovieDTO queryById(Integer id) throws Exception {
        HallMovieDTO o = getSqlSession().selectOne("com.wwwy.liuxing.hallmovie.dto.HallMovieMapper.queryById", id);
        return o;
    }

    @Override
    public Boolean insert(HallMovieDTO hallMovieDTO) throws Exception {
        int insert = getSqlSession().insert("com.wwwy.liuxing.hallmovie.dto.HallMovieMapper.insert", hallMovieDTO);
        return insert< SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public Boolean delete(Integer id) throws Exception {
        int delete = getSqlSession().delete("com.wwwy.liuxing.hallmovie.dto.HallMovieMapper.delete", id);
        return delete< SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public Boolean update(HallMovieDTO hallMovieDTO) throws Exception {
        int update = getSqlSession().update("com.wwwy.liuxing.hallmovie.dto.HallMovieMapper.update", hallMovieDTO);
        return update< SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public List<HallMovieDTO> queryByAny(String anyInfo) throws Exception {
        List<HallMovieDTO> list = getSqlSession().selectList("com.wwwy.liuxing.hallmovie.dto.HallMovieMapper.queryAny", anyInfo);
        return list;
    }

    @Override
    public Boolean deleteBatchAreas(int[] haMoId) throws Exception {
        int delete = getSqlSession().delete("com.wwwy.liuxing.hallmovie.dto.HallMovieMapper.batchDeleteHallMovie", haMoId);
        return delete< SysConfig.BeforeConfig.PAGE_START?false:true;
    }


}
