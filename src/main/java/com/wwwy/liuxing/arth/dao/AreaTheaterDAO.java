package com.wwwy.liuxing.arth.dao;

import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.arth.dto.AreaTheaterDTO;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author W1665
 * @date 2018/4/16
 */
@Repository
public class AreaTheaterDAO extends SqlSessionDaoSupport implements IAreaTheaterDAO {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }



    @Override
    public List<AreaTheaterDTO> queryAllArea() throws Exception {
        List<AreaTheaterDTO> list = getSqlSession().selectList("com.wwwy.liuxin.arth.dto.AreaTheaterMapper.queryAll");
        return list;
    }

    @Override
    public AreaTheaterDTO queryById(Integer id) throws Exception {
        AreaTheaterDTO o = getSqlSession().selectOne("com.wwwy.liuxin.arth.dto.AreaTheaterMapper.queryAreaTheaterById", id);
        return o;
    }

    @Override
    public Boolean insertAreaTheater(AreaTheaterDTO areaTheaterDTO) throws Exception {
        int insert = getSqlSession().insert("com.wwwy.liuxin.arth.dto.AreaTheaterMapper.insertAreaTheater", areaTheaterDTO);
        return insert<SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public Boolean deleteAreaTheater(Integer id) throws Exception {
        int delete = getSqlSession().delete("com.wwwy.liuxin.arth.dto.AreaTheaterMapper.deleteAreaTheater", id);
        return delete<SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public Boolean updateAreaTheater(AreaTheaterDTO areaTheaterDTO) throws Exception {
        int update = getSqlSession().update("com.wwwy.liuxin.arth.dto.AreaTheaterMapper.updateAreaTheater", areaTheaterDTO);
        return update<SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public List<AreaTheaterDTO> queryAreaTheaterByAny(String anyInfo) throws Exception {
        List<AreaTheaterDTO> list = getSqlSession().selectList("com.wwwy.liuxin.arth.dto.AreaTheaterMapper.queryAny", anyInfo);
        return list;
    }

    @Override
    public Boolean deleteBatchAreas(int[] areaId) throws Exception {
        int delete = getSqlSession().delete("com.wwwy.liuxin.arth.dto.AreaTheaterMapper.batchDeleteAreaTheater", areaId);
        return delete< SysConfig.BeforeConfig.PAGE_START?false:true;
    }
}
