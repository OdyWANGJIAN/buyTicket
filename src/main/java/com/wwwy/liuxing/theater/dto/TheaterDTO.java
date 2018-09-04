package com.wwwy.liuxing.theater.dto;

import com.wwwy.liuxing.hall.dto.HallDTO;

import java.io.Serializable;
import java.util.List;

/**
 *电影院实体类
 * @author W1665
 * @date 2018/4/10
 */
public class TheaterDTO implements Serializable {

    public static final long serialVersionUID=1L;

    /**
     * 电影院id
     */
    private Integer theaterId;

    /**
     * 电影院名字
     */
    private String theaterName;

    /**
     * 电影院地址
     */
    private String theaterAddress;

    /**
     * 电影院电话
     */
    private String theaterPhone;

    /**
     * 电影院地图经度
     */
    private String theaterLongitude;

    /**
     * 电影院地图纬度
     */
    private String theaterLatitude;

    /**
     * 电影院对应影厅的集合
     */
    private List<HallDTO> hallDTOList;

    public Integer getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    /**
     * 解决页面每个电影刚在影院的最低价格，而设置的属性
     */
    private Integer lowestPrice;

    public TheaterDTO() {
    }

    public TheaterDTO(Integer theaterId, String theaterName, String theaterAddress, String theaterPhone, String theaterLongitude, String theaterLatitude) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.theaterAddress = theaterAddress;
        this.theaterPhone = theaterPhone;
        this.theaterLongitude = theaterLongitude;
        this.theaterLatitude = theaterLatitude;
    }

    @Override
    public String toString() {
        return "TheaterDTO{" +
                "theaterId=" + theaterId +
                ", theaterName='" + theaterName + '\'' +
                ", theaterAddress='" + theaterAddress + '\'' +
                ", theaterPhone='" + theaterPhone + '\'' +
                ", theaterLongitude='" + theaterLongitude + '\'' +
                ", theaterLatitude='" + theaterLatitude + '\'' +
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

        TheaterDTO that = (TheaterDTO) o;

        if (theaterId != null ? !theaterId.equals(that.theaterId) : that.theaterId != null) {
            return false;
        }
        if (theaterName != null ? !theaterName.equals(that.theaterName) : that.theaterName != null) {
            return false;
        }
        if (theaterAddress != null ? !theaterAddress.equals(that.theaterAddress) : that.theaterAddress != null) {
            return false;
        }
        if (theaterPhone != null ? !theaterPhone.equals(that.theaterPhone) : that.theaterPhone != null) {
            return false;
        }
        return theaterLongitude != null ? theaterLongitude.equals(that.theaterLongitude) : that.theaterLongitude == null && (theaterLatitude != null ? theaterLatitude.equals(that.theaterLatitude) : that.theaterLatitude == null);

    }

    @Override
    public int hashCode() {
        int result = theaterId != null ? theaterId.hashCode() : 0;
        result = 31 * result + (theaterName != null ? theaterName.hashCode() : 0);
        result = 31 * result + (theaterAddress != null ? theaterAddress.hashCode() : 0);
        result = 31 * result + (theaterPhone != null ? theaterPhone.hashCode() : 0);
        result = 31 * result + (theaterLongitude != null ? theaterLongitude.hashCode() : 0);
        result = 31 * result + (theaterLatitude != null ? theaterLatitude.hashCode() : 0);
        return result;
    }

    public List<HallDTO> getHallDTOList() {
        return hallDTOList;
    }

    public void setHallDTOList(List<HallDTO> hallDTOList) {
        this.hallDTOList = hallDTOList;
    }

    public Integer getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterAddress() {
        return theaterAddress;
    }

    public void setTheaterAddress(String theaterAddress) {
        this.theaterAddress = theaterAddress;
    }

    public String getTheaterPhone() {
        return theaterPhone;
    }

    public void setTheaterPhone(String theaterPhone) {
        this.theaterPhone = theaterPhone;
    }

    public String getTheaterLongitude() {
        return theaterLongitude;
    }

    public void setTheaterLongitude(String theaterLongitude) {
        this.theaterLongitude = theaterLongitude;
    }

    public String getTheaterLatitude() {
        return theaterLatitude;
    }

    public void setTheaterLatitude(String theaterLatitude) {
        this.theaterLatitude = theaterLatitude;
    }
}
