package com.wwwy.liuxing.movie.dao.impl;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.movie.dao.IMovieDao;
import com.wwwy.liuxing.movie.dto.MovieDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 跟电影相关的dao层实体类
 */
@Repository
public class MovieDao extends SqlSessionDaoSupport implements IMovieDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 根据城市名查询所有电影id，电影名，电影图片，电影评分,返回的是带有这四个属性值得MovieDTO对象集合
     *
     * @param cityName
     * @return
     * @throws Exception
     */
    @Override
    public List<MovieDTO> getAllMovieByCityName(String cityName) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("cityName", cityName);
        List<MovieDTO> movieList = getSqlSession().selectList("com.wwwy.liuxing.movie.dto.MovieMapper.queryAllMovieByCityName", map);
        return movieList;
    }

    /**
     * 根据传入的条件动态查询符合的一个或多个条件的电影集合
     *
     * @param type    影片类型
     * @param country 影片国家
     * @param date    影片上映时间
     * @return
     * @throws Exception
     */
    @Override
    public List<MovieDTO> getMoviesByCondition(String type, String country, String date) throws Exception {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieDate(date);
        movieDTO.setMovieCountry(country);
        movieDTO.setMovieType(type);
        List<MovieDTO> list = getSqlSession().selectList("com.wwwy.liuxing.movie.dto.MovieMapper.selectMovieByCondition", movieDTO);
        return list;
    }
    /**
     * 根据城市ID和电影ID获得一个电影信息
     * @param cityId
     * @param movieId
     * @return
     * @throws Exception
     */
    @Override
    public MovieDTO getMovieByCityIdAndMovieId(Integer cityId, Integer movieId) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("cityId",cityId);
        map.put("movieId",movieId);
        MovieDTO movie = getSqlSession().selectOne("com.wwwy.liuxing.movie.dto.MovieMapper.getOneMovieByCityIdAnDMovieId", map);
        return movie;
    }

    @Override
    public MovieDTO queryMovieById(Integer id) throws Exception {
        MovieDTO o = getSqlSession().selectOne("com.wwwy.liuxing.movie.dto.MovieMapper.getMovieById", id);
        return o;
    }


    /*
    *
    * 后台查询所有电影信息
    * */
    @Override
    public List<MovieDTO> getMovieInfo() throws Exception {
        return getSqlSession().selectList("com.wwwy.liuxing.movie.dto.MovieMapper.getMovieInfo");
    }

    /*
    * 后台增加电影信息
    * */
    @Override
    public Integer insertMovieInfo(MovieDTO movieDTO) throws Exception {
        return getSqlSession().insert("com.wwwy.liuxing.movie.dto.MovieMapper.insertMovieInfo",movieDTO);
    }

    /*
    * 后台更改电影信息
    * */
    @Override
    public Integer upadetaMovieInfo(MovieDTO movieDTO) throws Exception {
        return getSqlSession().update("com.wwwy.liuxing.movie.dto.MovieMapper.updateMovieInfo",movieDTO);
    }

    /*
    * 后台通过ID获取电影信息
    * */
    @Override
    public MovieDTO getMovieInfoById(Integer moiveId) throws Exception {
        return getSqlSession().selectOne("com.wwwy.liuxing.movie.dto.MovieMapper.getMovieInfoById",moiveId);
    }

    /*
    * 后台删除电影信息
    * */
    @Override
    public Integer deleteMovieInfoById(Integer moiveId) throws Exception {
        return getSqlSession().delete("com.wwwy.liuxing.movie.dto.MovieMapper.deleteMovieInfoById",moiveId);
    }

    /*
    * 条件查询电影信息
    * */
    @Override
    public List<MovieDTO> criteriaQueryMovie(String anyInfo) throws Exception {
        List<MovieDTO> movieDTOPageInfo = getSqlSession().selectList("com.wwwy.liuxing.movie.dto.MovieMapper.criteriaQueryMovie", anyInfo);
        return movieDTOPageInfo;
    }
}
