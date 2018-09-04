package com.wwwy.liuxing.arth.controller;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.arth.dao.IAreaTheaterDAO;
import com.wwwy.liuxing.arth.dto.AreaTheaterDTO;
import com.wwwy.liuxing.arth.service.IAreaTheaterService;
import com.wwwy.liuxing.system.SysConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author W1665
 * @date 2018/4/16
 */
@Controller
@RequestMapping("/areaTheater")
public class AreaTheaterController {

    private static final Logger logger = Logger.getLogger(AreaTheaterController.class);

    @Autowired
    private IAreaTheaterService areaTheaterService;

    @Autowired
    private IAreaTheaterDAO areaTheaterDAO;


    @RequestMapping("/all")
    public String queryAll(HttpServletRequest request, ModelMap modelMap){
        String pageStr = request.getParameter("page");
        if(null==pageStr){
            pageStr= SysConfig.BeforeConfig.PAGE_STR;
        }
        Integer page = Integer.parseInt(pageStr);
        try {
            PageInfo<AreaTheaterDTO> pageInfo = areaTheaterService.queryAll(page);
            List<AreaTheaterDTO> areaTheaterDTOList = pageInfo.getList();
            modelMap.addAttribute("page", pageInfo);
            modelMap.addAttribute("areaTheaterDTOList",areaTheaterDTOList);
            return "hou_areaTheater_list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }

    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insertAreaTheater(HttpServletRequest request){
        String areaId = request.getParameter("areaId");
        String theaterId = request.getParameter("theaterId");
        AreaTheaterDTO areaTheaterDTO = new AreaTheaterDTO();
        areaTheaterDTO.setFkArId(Integer.parseInt(areaId));
        areaTheaterDTO.setFkThId(Integer.parseInt(theaterId));
        try {
            Boolean aBoolean = areaTheaterService.insertAreaTheater(areaTheaterDTO);
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
    public String deleteAreaTheater(HttpServletRequest request){
        String id = request.getParameter("id");
        try {
            Boolean aBoolean = areaTheaterService.deleteAreaTheater(Integer.parseInt(id));
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
            AreaTheaterDTO areaTheaterDTO = areaTheaterService.queryById(Integer.parseInt(id));
            modelMap.addAttribute("areaTheaterDTO",areaTheaterDTO);
            return "hou_area_theater_update";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletRequest request){
        String areaId = request.getParameter("areaId");
        String theaterId = request.getParameter("theaterId");
        String id = request.getParameter("id");
        AreaTheaterDTO areaTheaterDTO = new AreaTheaterDTO();
        areaTheaterDTO.setArThId(Integer.parseInt(id));
        areaTheaterDTO.setFkArId(Integer.parseInt(areaId));
        areaTheaterDTO.setFkThId(Integer.parseInt(theaterId));
        try {
            Boolean aBoolean = areaTheaterService.updateAreaTheater(areaTheaterDTO);
            if(aBoolean){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("/anyInfo")
    public String queryByAny(HttpServletRequest request,ModelMap modelMap){
        String anyInfo = request.getParameter("anyInfo");
        String page = request.getParameter("page");
        try {
            PageInfo<AreaTheaterDTO> pageInfo = areaTheaterService.queryAreaTheaterByAny(anyInfo, Integer.parseInt(page));
            List<AreaTheaterDTO> list = pageInfo.getList();
            modelMap.addAttribute("page", pageInfo);
            modelMap.addAttribute("areaTheaterDTOList",list);
            return "hou_arae_theater_any_list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }

    }

    @RequestMapping("/deleteBatch")
    @ResponseBody
    public String deleteBatchAreas(HttpServletRequest request, ModelMap modelMap) {
        String ids = request.getParameter("ids");
        logger.debug("::::::ids" + ids);
        String[] idStr = StringUtils.split(ids, ",");
        logger.debug(".......idStr" + idStr);
        int[] areaIds = Arrays.stream(idStr).mapToInt(Integer::valueOf).toArray();
        logger.debug(".........areaIds" + areaIds.toString());
        try {
            Boolean aBoolean = areaTheaterService.deleteBatchAreas(areaIds);
            if (aBoolean) {
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }


}
