package com.wwwy.liuxing.hallmovie.controller;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.hallmovie.service.IHallMovieService;
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
 * @date 2018/4/18
 */
@Controller
@RequestMapping("/hallMovie")
public class HallMovieController {


    private static final Logger logger = Logger.getLogger(HallMovieController.class);

    @Autowired
    private IHallMovieService hallMovieService;


    @RequestMapping("/all")
    public String queryAll(HttpServletRequest request, ModelMap modelMap){
        String page = request.getParameter("page");
        try {
            PageInfo<HallMovieDTO> pageInfo = hallMovieService.queryAll(Integer.parseInt(page));
            List<HallMovieDTO> list = pageInfo.getList();
            modelMap.addAttribute("page",pageInfo);
            modelMap.addAttribute("hallMovieList",list);
            return "hou_hall_movie_list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String isnert(HttpServletRequest request){
        String hallId = request.getParameter("hallId");
        String movieId = request.getParameter("movieId");
        String movieRuntime = request.getParameter("movieRuntime");
        String moviePrice = request.getParameter("moviePrice");
        String movieVersion = request.getParameter("movieVersion");
        HallMovieDTO hallMovieDTO = new HallMovieDTO();
        hallMovieDTO.setFkHallId(Integer.parseInt(hallId));
        hallMovieDTO.setFkMovieId(Integer.parseInt(movieId));
        hallMovieDTO.setMovieRuntime(movieRuntime);
        hallMovieDTO.setMoviePrice(Integer.parseInt(moviePrice));
        hallMovieDTO.setMovieVersion(movieVersion);
        try {
            Boolean insert = hallMovieService.insert(hallMovieDTO);
            if(insert){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request){
        String id = request.getParameter("id");
        try {
            Boolean delete = hallMovieService.delete(Integer.parseInt(id));
            if(delete){
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
            HallMovieDTO hallMovieDTO = hallMovieService.queryById(Integer.parseInt(id));
            modelMap.addAttribute("hallMovieDTO",hallMovieDTO);
            return "hou_hall_movie_update";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(HttpServletRequest request){
        String id = request.getParameter("id");
        String hallId = request.getParameter("hallId");
        String movieId = request.getParameter("movieId");
        String movieRuntime = request.getParameter("movieRuntime");
        String moviePrice = request.getParameter("moviePrice");
        String movieVersion = request.getParameter("movieVersion");
        HallMovieDTO hallMovieDTO = new HallMovieDTO();
        hallMovieDTO.setHaMoId(Integer.parseInt(id));
        hallMovieDTO.setFkHallId(Integer.parseInt(hallId));
        hallMovieDTO.setFkMovieId(Integer.parseInt(movieId));
        hallMovieDTO.setMovieRuntime(movieRuntime);
        hallMovieDTO.setMoviePrice(Integer.parseInt(moviePrice));
        hallMovieDTO.setMovieVersion(movieVersion);
        try {
            Boolean update = hallMovieService.update(hallMovieDTO);
            if(update){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("/anyInfo")
    public String queryByAny(HttpServletRequest request,ModelMap modelMap){
        String page = request.getParameter("page");
        String anyInfo = request.getParameter("anyInfo");
        try {
            PageInfo<HallMovieDTO> pageInfo = hallMovieService.queryByAny(anyInfo,Integer.parseInt(page));
            List<HallMovieDTO> list = pageInfo.getList();
            modelMap.addAttribute("page",pageInfo);
            modelMap.addAttribute("hallMovieList",list);
            return "hou_hall_movie_any_list";
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
        int[] haMoId = Arrays.stream(idStr).mapToInt(Integer::valueOf).toArray();
        try {
            Boolean aBoolean = hallMovieService.deleteBatch(haMoId);
            if (aBoolean) {
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }



}
