package com.wwwy.liuxing.cart.dto;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/16.
 */
public class CartDTO implements Serializable{
    public static final long serialVersionUID =1L;
    private Integer cartId;
    private String selectedSets;
    private String movieName;
    private String movieVersion;
    private String watchingTime;
    private String movieImg;
    private String cinemaName;
    private String hallName;
    private Integer totalPrice;
    private String tele;

    public String getSelectedSets() {
        return selectedSets;
    }

    public void setSelectedSets(String selectedSets) {
        this.selectedSets = selectedSets;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieVersion() {
        return movieVersion;
    }

    public void setMovieVersion(String movieVersion) {
        this.movieVersion = movieVersion;
    }

    public String getWatchingTime() {
        return watchingTime;
    }

    public void setWatchingTime(String watchingTime) {
        this.watchingTime = watchingTime;
    }

    public String getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(String movieImg) {
        this.movieImg = movieImg;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartDTO)) return false;

        CartDTO cartDTO = (CartDTO) o;

        if (cartId != null ? !cartId.equals(cartDTO.cartId) : cartDTO.cartId != null) return false;
        if (selectedSets != null ? !selectedSets.equals(cartDTO.selectedSets) : cartDTO.selectedSets != null)
            return false;
        if (movieName != null ? !movieName.equals(cartDTO.movieName) : cartDTO.movieName != null) return false;
        if (movieVersion != null ? !movieVersion.equals(cartDTO.movieVersion) : cartDTO.movieVersion != null)
            return false;
        if (watchingTime != null ? !watchingTime.equals(cartDTO.watchingTime) : cartDTO.watchingTime != null)
            return false;
        if (movieImg != null ? !movieImg.equals(cartDTO.movieImg) : cartDTO.movieImg != null) return false;
        if (cinemaName != null ? !cinemaName.equals(cartDTO.cinemaName) : cartDTO.cinemaName != null) return false;
        if (hallName != null ? !hallName.equals(cartDTO.hallName) : cartDTO.hallName != null) return false;
        if (totalPrice != null ? !totalPrice.equals(cartDTO.totalPrice) : cartDTO.totalPrice != null) return false;
        return tele != null ? tele.equals(cartDTO.tele) : cartDTO.tele == null;

    }

    @Override
    public int hashCode() {
        int result = cartId != null ? cartId.hashCode() : 0;
        result = 31 * result + (selectedSets != null ? selectedSets.hashCode() : 0);
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (movieVersion != null ? movieVersion.hashCode() : 0);
        result = 31 * result + (watchingTime != null ? watchingTime.hashCode() : 0);
        result = 31 * result + (movieImg != null ? movieImg.hashCode() : 0);
        result = 31 * result + (cinemaName != null ? cinemaName.hashCode() : 0);
        result = 31 * result + (hallName != null ? hallName.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (tele != null ? tele.hashCode() : 0);
        return result;
    }
}

