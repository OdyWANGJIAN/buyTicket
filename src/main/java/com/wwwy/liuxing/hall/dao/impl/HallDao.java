package com.wwwy.liuxing.hall.dao.impl;

import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hall.dao.IHallDao;
import com.wwwy.liuxing.system.SysConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 有关影厅的dao层
 */
@Repository
public class HallDao extends SqlSessionDaoSupport implements IHallDao {
    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 根据影院id和影厅id获取影厅详细信息（座位信息）
     * @param theaterId
     * @param hallId
     * @return
     */
    @Override
    public HallDTO queryHallByTheaterIdAndHallId(Integer theaterId, Integer hallId) throws Exception{
        HashMap<String, Object> map = new HashMap<>();
        map.put("theaterId",1);
        map.put("hallId",1);
        HallDTO hall = getSqlSession().selectOne("com.wwwy.liuxing.hall.dto.HallMapper.queryHallInfoByHallId", map);
        return hall;
    }

    @Override
    public HallDTO queryByName(String name) throws Exception {
        HallDTO hallDTO = getSqlSession().selectOne("com.wwwy.liuxing.hall.dto.HallMapper.queryExistPosition", name);
        return hallDTO;
    }

    @Override
    public List<HallDTO> queryAllHall() throws Exception {
        List<HallDTO> list = getSqlSession().selectList("com.wwwy.liuxing.hall.dto.HallMapper.queryAll");
        return list;
    }

    @Override
    public HallDTO queryHallById(Integer id) throws Exception {
        HallDTO o = getSqlSession().selectOne("com.wwwy.liuxing.hall.dto.HallMapper.queryHallById", id);
        return o;
    }

    @Override
    public Boolean insertHall(HallDTO hallDTO) throws Exception {
        int insert = getSqlSession().insert("com.wwwy.liuxing.hall.dto.HallMapper.insertHall", hallDTO);
        return insert< SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public Boolean deleteHall(Integer hallId) throws Exception {
        int delete = getSqlSession().delete("com.wwwy.liuxing.hall.dto.HallMapper.deleteHall", hallId);
        return delete< SysConfig.BeforeConfig.PAGE_START?false:true;
    }

    @Override
    public HallDTO getHallInfoById(Integer hallId) {
        return getSqlSession().selectOne("com.wwwy.liuxing.hall.dto.HallMapper.getHallInfoById",hallId);
    }

    @Override
    public Integer updateHallInfo(HallDTO hallDTO) throws Exception {
        return getSqlSession().update("com.wwwy.liuxing.hall.dto.HallMapper.updateHallInfo",hallDTO);
    }

    @Override
    public List<HallDTO> criteriaQueryHall(String anyInfo) throws Exception {
        return getSqlSession().selectList("com.wwwy.liuxing.hall.dto.HallMapper.criteriaQueryHall",anyInfo);
    }

    @Override
    public Integer tchDeleteHall(int [] hallId) throws Exception {
        return getSqlSession().delete("com.wwwy.liuxing.hall.dto.HallMapper.batchDeleteHall",hallId);
    }


}
