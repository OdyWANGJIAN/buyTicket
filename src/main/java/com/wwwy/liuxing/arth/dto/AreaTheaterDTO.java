package com.wwwy.liuxing.arth.dto;

import java.io.Serializable;

/**
 *
 * @author W1665
 * @date 2018/4/16
 */
public class AreaTheaterDTO implements Serializable {

    public static final long serialVersionUID=1L;

    private Integer arThId;

    private Integer fkArId;

    private Integer fkThId;

    private String areaName;

    private String theaterName;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public AreaTheaterDTO() {
    }

    public AreaTheaterDTO(Integer arThId, Integer fkArId, Integer fkThId) {
        this.arThId = arThId;
        this.fkArId = fkArId;
        this.fkThId = fkThId;
    }

    @Override
    public String toString() {
        return "AreaTheaterDTO{" +
                "arThId=" + arThId +
                ", fkArId=" + fkArId +
                ", fkThId=" + fkThId +
                ", areaName='" + areaName + '\'' +
                ", theaterName='" + theaterName + '\'' +
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

        AreaTheaterDTO that = (AreaTheaterDTO) o;

        if (arThId != null ? !arThId.equals(that.arThId) : that.arThId != null) {
            return false;
        }
        if (fkArId != null ? !fkArId.equals(that.fkArId) : that.fkArId != null) {
            return false;
        }
        if (fkThId != null ? !fkThId.equals(that.fkThId) : that.fkThId != null) {
            return false;
        }
        return areaName != null ? areaName.equals(that.areaName) : that.areaName == null && (theaterName != null ? theaterName.equals(that.theaterName) : that.theaterName == null);

    }

    @Override
    public int hashCode() {
        int result = arThId != null ? arThId.hashCode() : 0;
        result = 31 * result + (fkArId != null ? fkArId.hashCode() : 0);
        result = 31 * result + (fkThId != null ? fkThId.hashCode() : 0);
        result = 31 * result + (areaName != null ? areaName.hashCode() : 0);
        result = 31 * result + (theaterName != null ? theaterName.hashCode() : 0);
        return result;
    }

    public Integer getArThId() {
        return arThId;
    }

    public void setArThId(Integer arThId) {
        this.arThId = arThId;
    }

    public Integer getFkArId() {
        return fkArId;
    }

    public void setFkArId(Integer fkArId) {
        this.fkArId = fkArId;
    }

    public Integer getFkThId() {
        return fkThId;
    }

    public void setFkThId(Integer fkThId) {
        this.fkThId = fkThId;
    }
}
