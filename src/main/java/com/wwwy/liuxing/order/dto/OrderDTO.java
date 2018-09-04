package com.wwwy.liuxing.order.dto;

import java.io.Serializable;

/**
 *
 * @author W1665
 * @date 2018/4/18
 */
public class OrderDTO implements Serializable{

    public static final long serialVersionUID=1L;


    private Integer cartId;

    private Integer bookingNum;

    private String movieName;

    private String movieVersion;

    private String movieTime;

    private String movieImg;

    private String cinemaName;

    private String hallName;

    private String movieRound;

    private String place;

    private Integer originalPrice;

    private Integer totalPrice;

    private String tel;

    public OrderDTO() {
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "cartId=" + cartId +
                ", bookingNum=" + bookingNum +
                ", movieName='" + movieName + '\'' +
                ", movieVersion='" + movieVersion + '\'' +
                ", movieTime='" + movieTime + '\'' +
                ", movieImg='" + movieImg + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", hallName='" + hallName + '\'' +
                ", movieRound='" + movieRound + '\'' +
                ", place='" + place + '\'' +
                ", originalPrice=" + originalPrice +
                ", totalPrice=" + totalPrice +
                ", tel='" + tel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderDTO orderDTO = (OrderDTO) o;

        if (cartId != null ? !cartId.equals(orderDTO.cartId) : orderDTO.cartId != null) {
            return false;
        }
        if (bookingNum != null ? !bookingNum.equals(orderDTO.bookingNum) : orderDTO.bookingNum != null) {
            return false;
        }
        if (movieName != null ? !movieName.equals(orderDTO.movieName) : orderDTO.movieName != null) {
            return false;
        }
        if (movieVersion != null ? !movieVersion.equals(orderDTO.movieVersion) : orderDTO.movieVersion != null) {
            return false;
        }
        if (movieTime != null ? !movieTime.equals(orderDTO.movieTime) : orderDTO.movieTime != null) {
            return false;
        }
        if (movieImg != null ? !movieImg.equals(orderDTO.movieImg) : orderDTO.movieImg != null) {
            return false;
        }
        if (cinemaName != null ? !cinemaName.equals(orderDTO.cinemaName) : orderDTO.cinemaName != null) {
            return false;
        }
        if (hallName != null ? !hallName.equals(orderDTO.hallName) : orderDTO.hallName != null) {
            return false;
        }
        if (movieRound != null ? !movieRound.equals(orderDTO.movieRound) : orderDTO.movieRound != null) {
            return false;
        }
        if (place != null ? !place.equals(orderDTO.place) : orderDTO.place != null) {
            return false;
        }
        if (originalPrice != null ? !originalPrice.equals(orderDTO.originalPrice) : orderDTO.originalPrice != null) {
            return false;
        }
        return totalPrice != null ? totalPrice.equals(orderDTO.totalPrice) : orderDTO.totalPrice == null && (tel != null ? tel.equals(orderDTO.tel) : orderDTO.tel == null);

    }

    @Override
    public int hashCode() {
        int result = cartId != null ? cartId.hashCode() : 0;
        result = 31 * result + (bookingNum != null ? bookingNum.hashCode() : 0);
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (movieVersion != null ? movieVersion.hashCode() : 0);
        result = 31 * result + (movieTime != null ? movieTime.hashCode() : 0);
        result = 31 * result + (movieImg != null ? movieImg.hashCode() : 0);
        result = 31 * result + (cinemaName != null ? cinemaName.hashCode() : 0);
        result = 31 * result + (hallName != null ? hallName.hashCode() : 0);
        result = 31 * result + (movieRound != null ? movieRound.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (originalPrice != null ? originalPrice.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        return result;
    }

    public OrderDTO(Integer cartId, Integer bookingNum, String movieName, String movieVersion, String movieTime, String movieImg, String cinemaName, String hallName, String movieRound, String place, Integer originalPrice, Integer totalPrice, String tel) {
        this.cartId = cartId;
        this.bookingNum = bookingNum;
        this.movieName = movieName;
        this.movieVersion = movieVersion;
        this.movieTime = movieTime;
        this.movieImg = movieImg;
        this.cinemaName = cinemaName;
        this.hallName = hallName;
        this.movieRound = movieRound;
        this.place = place;
        this.originalPrice = originalPrice;
        this.totalPrice = totalPrice;
        this.tel = tel;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getBookingNum() {
        return bookingNum;
    }

    public void setBookingNum(Integer bookingNum) {
        this.bookingNum = bookingNum;
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

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
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

    public String getMovieRound() {
        return movieRound;
    }

    public void setMovieRound(String movieRound) {
        this.movieRound = movieRound;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
