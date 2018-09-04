package com.wwwy.liuxing.cart.service.impl;

import com.wwwy.liuxing.cache.IMovieCache;
import com.wwwy.liuxing.cart.dto.CartDTO;
import com.wwwy.liuxing.cart.service.ICartService;
import com.wwwy.liuxing.system.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */
@Service
public class CartService implements ICartService {
    @Autowired
    private IMovieCache movieCache;
    @Override
    public void saveBookingCart(String tele, CartDTO cartDTO) {
        ArrayList<String> paramList = new ArrayList<String>(20);
        paramList.add(cartDTO.getMovieName());
        paramList.add(cartDTO.getWatchingTime());
        paramList.add(cartDTO.getCinemaName());
        paramList.add(cartDTO.getHallName());
        paramList.add(cartDTO.getSelectedSets());
        paramList.add(cartDTO.getTotalPrice()+"");
        String key= SysConfig.BeforeConfig.PREFIX_BOOKING+tele+cartDTO.getMovieName();
        movieCache.saveList(key,paramList);
    }

    @Override
    public CartDTO getBookingCart(String tele, String movieName) {
        CartDTO cartDTO = new CartDTO();
        String key=SysConfig.BeforeConfig.PREFIX_BOOKING+tele+movieName;
        List<String> resultList = movieCache.getAllByKey(key);
        cartDTO.setMovieName(resultList.get(0));
        cartDTO.setWatchingTime(resultList.get(1));
        cartDTO.setCinemaName(resultList.get(2));
        cartDTO.setHallName(resultList.get(3));
        cartDTO.setSelectedSets(resultList.get(4));
        cartDTO.setTotalPrice(Integer.parseInt(resultList.get(5)));
        return cartDTO;
    }

    @Override
    public List<String> getSetList(String selectedSets) {
        String[] split = selectedSets.split(",");
        List<String> arrayList = Arrays.asList(split);
        return arrayList;
    }
}
