package com.wwwy.liuxing.hall.dto;

import com.wwwy.liuxing.movie.dto.MovieDTO;
import com.wwwy.liuxing.theater.dto.TheaterDTO;
import com.wwwy.liuxing.position.PositionDTO;

import java.io.Serializable;
import java.util.List;

/**
 *影厅实体类
 * @author W1665
 * @date 2018/4/10
 */
public class HallDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 影厅id
     */
    private Integer hallId;

    /**
     * 影厅名称
     */
    private String hallName;

    /**
     * 影院主键做外键
     */
    private Integer fkTheaterId;

    /**
     * 影厅座位的行数
     */
    private Integer hallCoordinateX;

    /**
     * 影厅座位的列数
     */
    private Integer hallCoordinateY;

    /**
     * 影厅对应的电影的集合
     */
    private List<MovieDTO> movieDTOList;
    /**
     * 影厅对应的座位的集合
     */
    private List<PositionDTO> positionDTOList;

    /*
    * 影院属性
    * */
    private List<TheaterDTO> theaterDTOList;

    private String theaterName;


    public HallDTO() {
        super();
    }

    @Override
    public String toString() {
        return "HallDTO{" +
                "hallId=" + hallId +
                ", hallName='" + hallName + '\'' +
                ", fkTheaterId=" + fkTheaterId +
                ", hallCoordinateX=" + hallCoordinateX +
                ", hallCoordinateY=" + hallCoordinateY +
                ", movieDTOList=" + movieDTOList +
                ", positionDTOList=" + positionDTOList +
                ", theaterDTOList=" + theaterDTOList +
                ", theaterName='" + theaterName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HallDTO hallDTO = (HallDTO) o;

        if (hallId != null ? !hallId.equals(hallDTO.hallId) : hallDTO.hallId != null) return false;
        if (hallName != null ? !hallName.equals(hallDTO.hallName) : hallDTO.hallName != null) return false;
        if (fkTheaterId != null ? !fkTheaterId.equals(hallDTO.fkTheaterId) : hallDTO.fkTheaterId != null) return false;
        if (hallCoordinateX != null ? !hallCoordinateX.equals(hallDTO.hallCoordinateX) : hallDTO.hallCoordinateX != null)
            return false;
        if (hallCoordinateY != null ? !hallCoordinateY.equals(hallDTO.hallCoordinateY) : hallDTO.hallCoordinateY != null)
            return false;
        if (movieDTOList != null ? !movieDTOList.equals(hallDTO.movieDTOList) : hallDTO.movieDTOList != null)
            return false;
        if (positionDTOList != null ? !positionDTOList.equals(hallDTO.positionDTOList) : hallDTO.positionDTOList != null)
            return false;
        if (theaterDTOList != null ? !theaterDTOList.equals(hallDTO.theaterDTOList) : hallDTO.theaterDTOList != null)
            return false;
        return theaterName != null ? theaterName.equals(hallDTO.theaterName) : hallDTO.theaterName == null;

    }

    @Override
    public int hashCode() {
        int result = hallId != null ? hallId.hashCode() : 0;
        result = 31 * result + (hallName != null ? hallName.hashCode() : 0);
        result = 31 * result + (fkTheaterId != null ? fkTheaterId.hashCode() : 0);
        result = 31 * result + (hallCoordinateX != null ? hallCoordinateX.hashCode() : 0);
        result = 31 * result + (hallCoordinateY != null ? hallCoordinateY.hashCode() : 0);
        result = 31 * result + (movieDTOList != null ? movieDTOList.hashCode() : 0);
        result = 31 * result + (positionDTOList != null ? positionDTOList.hashCode() : 0);
        result = 31 * result + (theaterDTOList != null ? theaterDTOList.hashCode() : 0);
        result = 31 * result + (theaterName != null ? theaterName.hashCode() : 0);
        return result;
    }

    public String getTheaterName() {

        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getFkTheaterId() {
        return fkTheaterId;
    }

    public void setFkTheaterId(Integer fkTheaterId) {
        this.fkTheaterId = fkTheaterId;
    }

    public Integer getHallCoordinateX() {
        return hallCoordinateX;
    }

    public void setHallCoordinateX(Integer hallCoordinateX) {
        this.hallCoordinateX = hallCoordinateX;
    }

    public Integer getHallCoordinateY() {
        return hallCoordinateY;
    }

    public void setHallCoordinateY(Integer hallCoordinateY) {
        this.hallCoordinateY = hallCoordinateY;
    }

    public List<MovieDTO> getMovieDTOList() {
        return movieDTOList;
    }

    public void setMovieDTOList(List<MovieDTO> movieDTOList) {
        this.movieDTOList = movieDTOList;
    }

    public List<PositionDTO> getPositionDTOList() {
        return positionDTOList;
    }

    public void setPositionDTOList(List<PositionDTO> positionDTOList) {
        this.positionDTOList = positionDTOList;
    }

    public List<TheaterDTO> getTheaterDTOList() {
        return theaterDTOList;
    }

    public void setTheaterDTOList(List<TheaterDTO> theaterDTOList) {
        this.theaterDTOList = theaterDTOList;
    }
}