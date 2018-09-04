package com.wwwy.liuxing.hall.controller;

import com.github.pagehelper.PageInfo;
import com.wwwy.liuxing.hall.dto.HallDTO;
import com.wwwy.liuxing.hall.service.IHallService;
import com.wwwy.liuxing.position.PositionDTO;
import com.wwwy.liuxing.hallmovie.dto.HallMovieDTO;
import com.wwwy.liuxing.hallmovie.service.IHallMovieService;
import com.wwwy.liuxing.movie.dto.MovieDTO;
import com.wwwy.liuxing.movie.service.IMovieService;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import com.wwwy.liuxing.theater.service.ITheaterService;
import org.apache.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.List;

/**
 * Created by wanghao on 2018/4/12.
 * 有关影厅的controller层
 */
@Controller
@RequestMapping("/hall")
public class HallController {
    private static final Logger logger = Logger.getLogger(HallController.class);
    @Autowired
    private IHallService hallService;

    @Autowired
    private IMovieService movieService;
    @Autowired
    private IHallMovieService hallMovieService;
    @Autowired
    private  ITheaterService theaterService;

    @RequestMapping("/getHall")
    public String getHallInfo(String theaterId, String hallId, ModelMap modelMap) {
        logger.info("这里是/hall/getHall controller层路径 ");
        try {
            HallDTO hallDTO = hallService.queryHallByTheaterIdAndHallId(theaterId, hallId);
            logger.info("controller层从数据库取得影厅数据：" + hallDTO.getHallName());
            modelMap.put("hallDTO", hallDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "qian_liuxing_cinema_hall_seat";
    }
    @RequestMapping("/getMovieHall")
    public String getMovieHall(String cityId,String theaterId,String movieId,ModelMap modelMap){
        logger.info("这是 /getMovieHall 方法");
        try {
            TheaterDTO theaterDTO = theaterService.queryTheaterById(Integer.parseInt(theaterId));
            MovieDTO movieDTO = movieService.getMovieByCityIdAndMovieId(cityId, movieId);
            List<HallMovieDTO> hallMovieList = hallMovieService.queryPlayingHallMovie(cityId, theaterId, movieId);
            modelMap.put("theaterDTO",theaterDTO);
            modelMap.put("movieDTO",movieDTO);
            modelMap.put("hallMovieList",hallMovieList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "qian_pick_movie";
    }

    @RequestMapping("/all")
    public String queryAllHall(HttpServletRequest request,ModelMap modelMap){
        String page = request.getParameter("page");
        try {
            PageInfo<HallDTO> pageInfo = hallService.queryAllHall(Integer.parseInt(page));
            List<HallDTO> list = pageInfo.getList();
            modelMap.addAttribute("page",pageInfo);
            modelMap.addAttribute("hallList",list);
            return "hou_hall_list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error404";
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insertHall(HttpServletRequest request){
        String hallName = request.getParameter("hallName");
        String theaterName = request.getParameter("theaterName");
        String hallCoordinateX = request.getParameter("hallCoordinateX");
        String hallCoordinateY = request.getParameter("hallCoordinateY");
        try {
            TheaterDTO theaterDTO = theaterService.queryTheaterByName(theaterName);
            HallDTO hallDTO = new HallDTO();
            hallDTO.setHallName(hallName);
            hallDTO.setFkTheaterId(theaterDTO.getTheaterId());
            hallDTO.setHallCoordinateX(Integer.parseInt(hallCoordinateX));
            hallDTO.setHallCoordinateY(Integer.parseInt(hallCoordinateY));
            Boolean aBoolean = hallService.insertHall(hallDTO);
            if (aBoolean){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }


    @RequestMapping("/querySeat")
    public String queryHallSeat(String hallName, Model model) {
        try {
            HallDTO hallDTO = hallService.queryByName(hallName);
            List<PositionDTO> positionDTOList = hallDTO.getPositionDTOList();
            model.addAttribute("hallDTO", hallDTO);
            model.addAttribute("positions",positionDTOList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "qian_liuxing_hall_seat";
    }
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteHallById(Integer hallId){
        try {
            Boolean deleteHall = hallService.deleteHall(hallId);
            if (deleteHall){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("/preUpdate")
    public String preUpdateHallInfo(Integer hallId,ModelMap modelMap){
        try {
            HallDTO hallInfoById = hallService.getHallInfoById(hallId);
            modelMap.addAttribute("hallInfoById",hallInfoById);
            logger.info("hallInfoById====================================="+hallInfoById);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_hall_update";
    }

    @RequestMapping("/update")
    public String updateHallInfo(HallDTO hallDTO,Integer page,ModelMap modelMap){
        try {
            boolean b = hallService.updateHallInfoById(hallDTO);
            if (b){
                PageInfo<HallDTO> hallDTOPageInfo = hallService.queryAllHall(page);
                List<HallDTO> list = hallDTOPageInfo.getList();
                logger.info("updateliast============================="+list);
                modelMap.addAttribute("page",hallDTOPageInfo);
                modelMap.addAttribute("hallList",list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_hall_list";
    }

    @RequestMapping("/anyInfo")
    public String criteriaQueryHall(Integer page,String anyInfo,ModelMap modelMap){
        try {
            PageInfo<HallDTO> hallDTOPageInfo = hallService.criteriaQueryHall(page, anyInfo);
            logger.info("===================================="+hallDTOPageInfo);
            List<HallDTO> list = hallDTOPageInfo.getList();
            logger.info("==================================="+list);
            modelMap.addAttribute("page",hallDTOPageInfo);
            modelMap.addAttribute("hallList",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hou_hall_list";
    }

    @RequestMapping("tchDelete")
    @ResponseBody
    public String tchDeleteHall(String ids){
        String[] split = StringUtils.split(ids, ",");
        int[] ints = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();
        logger.info(ints);
        try {
            boolean tchDeleteHall = hallService.tchDeleteHall(ints);
            if (tchDeleteHall){
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
