package com.wwwy.liuxing.theater.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import com.wwwy.liuxing.arth.dto.AreaTheaterDTO;
import com.wwwy.liuxing.city.dto.CityDTO;
import com.wwwy.liuxing.city.service.ICityService;
import com.wwwy.liuxing.system.SysConfig;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import com.wwwy.liuxing.theater.service.ITheaterService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author W1665
 * @date 2018/4/14
 */
@Controller
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private ITheaterService theaterService;

    @Autowired
    private ICityService cityService;

    @Autowired
    private IAreaService areaService;

    private static final Logger logger = Logger.getLogger(TheaterController.class);


    @RequestMapping("/cityArea")
    public String queryCityAndArea(HttpServletRequest request,ModelMap modelMap){
        String cityName = request.getParameter("cityName");
        try {
        if(null!=cityName){
            CityDTO cityDTO = cityService.queryCityByName(cityName);
            List<AreaDTO> areaDTOList = areaService.queryAllArea(cityDTO.getCityId());
            modelMap.addAttribute("areaDTOList",areaDTOList);
        }
        List<CityDTO> cityDTOList = cityService.queryAllCity();
        modelMap.addAttribute("cityDTOList",cityDTOList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_theater_list";
    }

    /**
     * 根据地区查询出所有的电影院并分页
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("/all")
    public String queryAllTheaterByAreaId(HttpServletRequest request,ModelMap modelMap){
        String pageStr = request.getParameter("page");
        String areaName = request.getParameter("areaName");
        logger.debug("areaId======"+areaName);
        if(null==pageStr){
            pageStr= SysConfig.BeforeConfig.PAGE_STR;
        }
        Integer page = Integer.parseInt(pageStr);
        try {
            PageInfo<TheaterDTO> pageInfo = theaterService.queryAllTheater(areaName, page);
            List<TheaterDTO> list = pageInfo.getList();
            modelMap.addAttribute("page",pageInfo);
            modelMap.addAttribute("theaterList",list);
            return "hou_theater_list";
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug(e);
            return "error404";
        }

    }

    /**
     * 新增了一个影院
     * @param request
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public String insertTheater(HttpServletRequest request){
        String theaterName = request.getParameter("theaterName");
        String theaterAddress = request.getParameter("theaterAddress");
        String theaterPhone = request.getParameter("theaterPhone");
        String theaterLongitude = request.getParameter("theaterLongitude");
        String theaterLatitude = request.getParameter("theaterLatitude");
        TheaterDTO theaterDTO = new TheaterDTO();
        theaterDTO.setTheaterName(theaterName);
        theaterDTO.setTheaterAddress(theaterAddress);
        theaterDTO.setTheaterPhone(theaterPhone);
        theaterDTO.setTheaterLongitude(theaterLongitude);
        theaterDTO.setTheaterLatitude(theaterLatitude);
        try {
            Boolean aBoolean = theaterService.insertTheater(theaterDTO);
            if(aBoolean){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return "fail";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteTheaterById(HttpServletRequest request){
        String theaterId = request.getParameter("theaterId");
        try {
            Boolean aBoolean = theaterService.deleteTheater(Integer.parseInt(theaterId));
            if(aBoolean){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("/preUpdate")
    public String preUpdate(HttpServletRequest request,ModelMap modelMap){
        String id = request.getParameter("id");
        try {
            TheaterDTO theaterDTO = theaterService.queryTheaterById(Integer.parseInt(id));
            modelMap.addAttribute("theaterDTO",theaterDTO);
            return "hou_theater_update";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletRequest request){
        String id = request.getParameter("id");
        String theaterName = request.getParameter("theaterName");
        String theaterAddress = request.getParameter("theaterAddress");
        String theaterPhone = request.getParameter("theaterPhone");
        String theaterLongitude = request.getParameter("theaterLongitude");
        String theaterLatitude = request.getParameter("theaterLatitude");
        try {
            Boolean aBoolean = theaterService.updateTheater(new TheaterDTO(Integer.parseInt(id), theaterName, theaterAddress, theaterPhone, theaterLongitude, theaterLatitude));
            if(aBoolean){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("/anyInfo")
    public String queryByAnyInfo(HttpServletRequest request,ModelMap modelMap){
        String anyInfo = request.getParameter("anyInfo");
        logger.debug("anyInfo::::"+anyInfo);
        String page = request.getParameter("page");
        try {
            PageInfo<TheaterDTO> pageInfo = theaterService.queryTheaterByAny(anyInfo, Integer.parseInt(page));
            List<TheaterDTO> list = pageInfo.getList();
            modelMap.addAttribute("page", pageInfo);
            modelMap.addAttribute("theaterList",list);
            return "hou_theater_list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }
    }

    @RequestMapping("/deleteBatch")
    @ResponseBody
    public String deleteBatch(HttpServletRequest request){
        String ids = request.getParameter("ids");
        logger.debug("::::::ids" + ids);
        String[] idStr = StringUtils.split(ids, ",");
        logger.debug(".......idStr" + idStr);
        int[] theaterIds = Arrays.stream(idStr).mapToInt(Integer::valueOf).toArray();
        logger.debug(".........theaterIds" + theaterIds.toString());
        try {
            Boolean aBoolean = theaterService.deleteBatchTheater(theaterIds);
            if (aBoolean) {
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
