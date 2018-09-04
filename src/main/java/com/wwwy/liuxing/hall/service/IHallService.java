package com.wwwy.liuxing.hall.service;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.hall.dto.HallDTO;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 有关影厅的service层
 */
public interface IHallService  {

    HallDTO queryHallByTheaterIdAndHallId(String theaterId, String hallId) throws Exception;

    /**
     * 查询出所有的影厅并分页
     * @param page
     * @return
     * @throws Exception
     */
    PageInfo<HallDTO> queryAllHall(Integer page)throws Exception;

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
     * 很久id删除一条记录
     * @param hallId
     * @return
     * @throws Exception
     */
    Boolean deleteHall(Integer hallId)throws Exception;

    /**
     * 根据影厅名称查询影厅的座位
     * @param name
     * @return
     */
    HallDTO queryByName(String name) throws Exception;

    /*
    * 根据ID获取信息
    * */
    HallDTO getHallInfoById(Integer hallId) throws Exception;

    /*
    *
    * 修改信息
    * */
    boolean updateHallInfoById(HallDTO hallDTO) throws Exception;

    /*
       条件查询
    */
    PageInfo<HallDTO> criteriaQueryHall(Integer page, String anyInfo) throws Exception;

    /*
    * 批量删除
    * */
    boolean tchDeleteHall(int[] hall) throws Exception;
}
