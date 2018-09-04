package com.wwwy.liuxing.hall.dao;

import com.wwwy.liuxing.hall.dto.HallDTO;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 获取影厅的详细信息
 */
public interface IHallDao {
    /**
     * 根据影院id和影厅ID获取影厅详细信息
     * @param theaterId
     * @param hallId
     * @return
     */
    HallDTO queryHallByTheaterIdAndHallId(Integer theaterId,Integer hallId) throws Exception;

    /**
     * 根据影厅名称查询影厅的座位
     * @param name
     * @return
     */
    HallDTO queryByName(String name) throws Exception;

    /**
     * 查询出所有的影厅
     * @return
     * @throws Exception
     */
    List<HallDTO> queryAllHall()throws Exception;

    /**
     * 根据id查询对应的厅
     * @param id
     * @return
     * @throws Exception
     */
    HallDTO queryHallById(Integer id)throws Exception;


    /**
     * 插入一条影厅记录
     * @param hallDTO
     * @return
     * @throws Exception
     */
    Boolean insertHall(HallDTO hallDTO)throws Exception;

    /**
     * 根据id删除一条记录
     * @param hallId
     * @return
     * @throws Exception
     */
    Boolean deleteHall(Integer hallId)throws Exception;

    /*
    * 通过ID获取影厅信息
    * */
    HallDTO getHallInfoById(Integer hallId)throws Exception;

    /*
    * 修改影厅信息
    * */
    Integer updateHallInfo(HallDTO hallDTO)throws Exception;

    /*
    * 条件查询
    * */
    List<HallDTO> criteriaQueryHall(String anyInfo)throws Exception;

    /*
    * 批量删除
    * */
    Integer tchDeleteHall(int[] hall)throws Exception;
}
