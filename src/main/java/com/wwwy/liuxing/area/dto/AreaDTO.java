package com.wwwy.liuxing.area.dto;

import com.wwwy.liuxing.city.dto.CityDTO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;

import java.io.Serializable;
import java.util.List;

/**
 *地区实体类
 * @author W1665
 * @date 2018/4/10
 */
public class AreaDTO implements Serializable {

    public static final long serialVersionUID=1L;

    /**
     * 地区id
     */
    private Integer areaId;

    /**
     * 地区名称
     */
    private String areaName;

    /**
     * 城市外键
     */
    private Integer fkCityId;

    private String cityName;
    /**
     * 地区对应的影院的集合
     */
    private List<TheaterDTO> theaterDTOList;

    /**
     * 地区对应城市的对象
     */
    private CityDTO cityDTO;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
    }

    public AreaDTO() {
    }

    public AreaDTO(Integer areaId, String areaName, Integer fkCityId) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.fkCityId = fkCityId;
    }

    @Override
    public String toString() {
        return "AreaDTO{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", fkCityId=" + fkCityId +
                ", cityName='" + cityName + '\'' +
                ", theaterDTOList=" + theaterDTOList +
                ", cityDTO=" + cityDTO +
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

        AreaDTO areaDTO = (AreaDTO) o;

        if (areaId != null ? !areaId.equals(areaDTO.areaId) : areaDTO.areaId != null) {
            return false;
        }
        if (areaName != null ? !areaName.equals(areaDTO.areaName) : areaDTO.areaName != null) {
            return false;
        }
        if (fkCityId != null ? !fkCityId.equals(areaDTO.fkCityId) : areaDTO.fkCityId != null) {
            return false;
        }
        if (cityName != null ? !cityName.equals(areaDTO.cityName) : areaDTO.cityName != null) {
            return false;
        }
        return theaterDTOList != null ? theaterDTOList.equals(areaDTO.theaterDTOList) : areaDTO.theaterDTOList == null && (cityDTO != null ? cityDTO.equals(areaDTO.cityDTO) : areaDTO.cityDTO == null);

    }

    @Override
    public int hashCode() {
        int result = areaId != null ? areaId.hashCode() : 0;
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        result = 31 * result + (fkCityId != null ? fkCityId.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (theaterDTOList != null ? theaterDTOList.hashCode() : 0);
        result = 31 * result + (cityDTO != null ? cityDTO.hashCode() : 0);
        return result;
    }

    public Integer getFkCityId() {
        return fkCityId;
    }

    public void setFkCityId(Integer fkCityId) {
        this.fkCityId = fkCityId;
    }

    public List<TheaterDTO> getTheaterDTOList() {
        return theaterDTOList;
    }

    public void setTheaterDTOList(List<TheaterDTO> theaterDTOList) {
        this.theaterDTOList = theaterDTOList;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
