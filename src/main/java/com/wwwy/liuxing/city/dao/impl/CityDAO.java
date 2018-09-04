package com.wwwy.liuxing.city.dao.impl;

import com.wwwy.liuxing.city.dao.ICityDAO;
import com.wwwy.liuxing.city.dto.CityDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/14
 */
@Repository
public class CityDAO extends SqlSessionDaoSupport implements ICityDAO {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public CityDTO queryCityById(Integer cityId)throws Exception {
        CityDTO cityDTO = getSqlSession().selectOne("com.wwwy.liuxing.city.dto.CityMapper.queryCityById", cityId);
        return cityDTO;
    }

    @Override
    public List<CityDTO> queryAllCity()throws Exception {
        List<CityDTO> list = getSqlSession().selectList("com.wwwy.liuxing.city.dto.CityMapper.queryAllCity");
        return list;
    }

    @Override
    public CityDTO queryCityByName(String cityName)throws Exception {
        CityDTO cityDTO = getSqlSession().selectOne("com.wwwy.liuxing.city.dto.CityMapper.queryCityByName", cityName);
        return cityDTO;
    }
}
