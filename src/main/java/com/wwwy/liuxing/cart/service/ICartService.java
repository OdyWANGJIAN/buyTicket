package com.wwwy.liuxing.cart.service;

import com.wwwy.liuxing.cart.dto.CartDTO;

import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */

public interface ICartService {
    void saveBookingCart(String tele, CartDTO cartDTO);
    CartDTO getBookingCart(String tele,String movieName);
    List<String> getSetList(String selectedSets);
}
