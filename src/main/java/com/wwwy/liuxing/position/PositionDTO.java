package com.wwwy.liuxing.position;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/18.
 */
public class PositionDTO implements Serializable {
    private static final long serialVersionUID =1L;
    private Integer positionId;
    private String positionName;
    private Integer state;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionDTO)) return false;

        PositionDTO that = (PositionDTO) o;

        if (positionId != null ? !positionId.equals(that.positionId) : that.positionId != null) return false;
        if (positionName != null ? !positionName.equals(that.positionName) : that.positionName != null) return false;
        return state != null ? state.equals(that.state) : that.state == null;

    }

    @Override
    public int hashCode() {
        int result = positionId != null ? positionId.hashCode() : 0;
        result = 31 * result + (positionName != null ? positionName.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
