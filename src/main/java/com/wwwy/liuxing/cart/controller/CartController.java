package com.wwwy.liuxing.cart.controller;

import com.wwwy.liuxing.cart.dto.CartDTO;
import com.wwwy.liuxing.cart.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * Created by Administrator on 2018/4/17.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;
    @RequestMapping("/showBooking")
    public String showBooking(String tele, String movieName, Model model){
        CartDTO cartDTO = cartService.getBookingCart(tele, movieName);
        String selectedSets = cartDTO.getSelectedSets();
        List<String> setList = cartService.getSetList(selectedSets);
        model.addAttribute("cart",cartDTO);
        model.addAttribute("setList",setList);
        return "waiting_for_pay";
    }
}
