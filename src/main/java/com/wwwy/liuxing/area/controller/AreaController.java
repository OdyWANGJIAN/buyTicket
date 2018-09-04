package com.wwwy.liuxing.area.controller;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.area.dto.AreaDTO;
import com.wwwy.liuxing.area.service.IAreaService;
import com.wwwy.liuxing.city.dto.CityDTO;
import com.wwwy.liuxing.system.SysConfig;
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
import java.util.Map;

/**
 * @author W1665
 * @date 2018/4/12
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private IAreaService areaService;

    private static final Logger logger = Logger.getLogger(AreaController.class);

    /**
     * 查询所有的地区并分页
     *
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("/all")
    public String queryAllArea(HttpServletRequest request, ModelMap modelMap) {
        String pageStr = request.getParameter("page");
        Integer page = Integer.parseInt(pageStr);
        try {
            PageInfo<AreaDTO> pageInfo = areaService.queryAllArea(SysConfig.BeforeConfig.PAGE_START, page);
            List<AreaDTO> list = pageInfo.getList();
            modelMap.addAttribute("page", pageInfo);
            modelMap.addAttribute("areaDTOsList", list);
            return "hou_area_list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }
    }

    /**
     * 插入一条新数据
     */
    @RequestMapping("/insert")
    @ResponseBody
    public String insertArea(String areaName, ModelMap modelMap) {
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setAreaName(areaName);
        areaDTO.setFkCityId(SysConfig.BeforeConfig.PAGE_START);
        try {
            Boolean aBoolean = areaService.insertArea(areaDTO);
            if (aBoolean == true) {
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    /**
     * 删除一条新数据
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteArea(String id) {
        try {
            Boolean aBoolean = areaService.deleteArea(Integer.parseInt(id));
            if (aBoolean == true) {
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    /**
     * 预更新
     *
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/preUpdate")
    public String preUpdate(String id, ModelMap modelMap) {
        try {
            AreaDTO areaDTO = areaService.queryAreaById(Integer.parseInt(id));
            modelMap.addAttribute("areaDTO", areaDTO);
            return "hou_area_update";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_main_page";
    }

    /**
     * 根据id更新一条数据
     *
     * @param areaName
     * @param id
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public String updateArea(String areaName, String id) {
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setAreaId(Integer.parseInt(id));
        areaDTO.setAreaName(areaName);
        try {
            Boolean aBoolean = areaService.updateArea(areaDTO);
            if (aBoolean == true) {
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }


    /**
     * 根据任意信息查询数据库，获取所有查询到的值
     *
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("/anyInfo")
    public String queryAreaByAny(HttpServletRequest request, ModelMap modelMap) {
        String anyInfo = request.getParameter("anyInfo");
        logger.debug("anyInfo" + anyInfo);
        String page = request.getParameter("page");
        try {
            PageInfo<AreaDTO> pageInfo = areaService.queryAreaByAny(anyInfo, Integer.parseInt(page));
            List<AreaDTO> list = pageInfo.getList();
            modelMap.addAttribute("page", pageInfo);
            modelMap.addAttribute("areaDTOsList", list);
            return "hou_area_any_list";
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.addAttribute("areaDTOsList", null);
            return "error404";
        }

    }

    @RequestMapping("/deleteBatch")
    @ResponseBody
    public String deleteBatchAreas(HttpServletRequest request) {
        String ids = request.getParameter("ids");
        logger.debug("::::::ids" + ids);
        String[] idStr = StringUtils.split(ids, ",");
        logger.debug(".......idStr" + idStr);
        int[] areaIds = Arrays.stream(idStr).mapToInt(Integer::valueOf).toArray();
        logger.debug(".........areaIds" + areaIds.toString());
        try {
            Boolean aBoolean = areaService.deleteBatchAreas(areaIds);
            logger.debug(";;;;;aBoolean" + aBoolean);
            if (aBoolean) {
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
