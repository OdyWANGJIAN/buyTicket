package com.wwwy.liuxing.theater.dao.impl;

import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.theater.dao.ITheaterDAO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class TheaterDAO extends SqlSessionDaoSupport implements ITheaterDAO {

    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 依照传入的pattern查询与之匹配的影院
     * @param pattern
     * @return
     */
    @Override
    public List<TheaterDTO> queryTheaterByPattern(String pattern) throws Exception {
        List<TheaterDTO> list = getSqlSession().selectList("com.wwwy.liuxing.theater.dto.TheaterMapper.queryByPattern", pattern);
        return list;
    }

    /**
     * 根据城市和电影获取放映该电影的电影院名和影院地址
     * （影院最低价格 用另一个sql在hallmovie_mapper.xml中查询每个放映该电影的最低价格）
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    @Override
    public List<TheaterDTO> queryLowestPriceTheaterList(Integer cityId, Integer movieId) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("cityId",cityId);
        map.put("movieId",movieId);
        List<TheaterDTO> theaterList = getSqlSession().selectList("com.wwwy.liuxing.theater.dto.TheaterMapper.queryLowestPriceTheaterList", map);
        return theaterList;
    }

    @Override
    public List<TheaterDTO> queryAllTheater(String areaName) throws Exception {
        List<TheaterDTO> list = getSqlSession().selectList("com.wwwy.liuxing.theater.dto.TheaterMapper.queryAllTheater", areaName);
        return list;
    }

    @Override
    public TheaterDTO queryTheaterById(Integer theaterId) throws Exception {
        TheaterDTO o = getSqlSession().selectOne("com.wwwy.liuxing.theater.dto.TheaterMapper.queryTheaterById", theaterId);
        return o;
    }

    @Override
    public Boolean insertTheater(TheaterDTO theaterDTO) throws Exception {
        int insert = getSqlSession().insert("com.wwwy.liuxing.theater.dto.TheaterMapper.insertTheater", theaterDTO);
        return insert< SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public Boolean deleteTheater(Integer theaterId) throws Exception {
        int delete = getSqlSession().delete("com.wwwy.liuxing.theater.dto.TheaterMapper.deleteTheater", theaterId);
        return delete< SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public Boolean updateTheater(TheaterDTO theaterDTO) throws Exception {
        int update = getSqlSession().update("com.wwwy.liuxing.theater.dto.TheaterMapper.updateTheater", theaterDTO);
        return update< SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public List<TheaterDTO> queryTheaterByAny(String anyInfo) throws Exception {
        List<TheaterDTO> list = getSqlSession().selectList("com.wwwy.liuxing.theater.dto.TheaterMapper.queryAny", anyInfo);
        return list;
    }

    @Override
    public Boolean deleteBatchTheater(int[] theaterId) throws Exception {
        int delete = getSqlSession().delete("com.wwwy.liuxing.theater.dto.TheaterMapper.batchDeleteAreas", theaterId);
        return delete< SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public TheaterDTO queryTheaterByName(String theaterName) throws Exception {
        TheaterDTO o = getSqlSession().selectOne("com.wwwy.liuxing.theater.dto.TheaterMapper.queryTheaterByName", theaterName);
        return o;
    }


}

