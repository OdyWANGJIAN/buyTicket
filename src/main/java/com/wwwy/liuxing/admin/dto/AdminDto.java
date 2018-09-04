package com.wwwy.liuxing.admin.dto;

/**
 * Created by Administrator on 2018/4/13.
 */
public class AdminDto {

    private Integer adminId;

    private String adminName;

    private String adminPassword;

    public AdminDto() {
        super();
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminDto adminDto = (AdminDto) o;

        if (adminId != null ? !adminId.equals(adminDto.adminId) : adminDto.adminId != null) return false;
        if (adminName != null ? !adminName.equals(adminDto.adminName) : adminDto.adminName != null) return false;
        return adminPassword != null ? adminPassword.equals(adminDto.adminPassword) : adminDto.adminPassword == null;

    }

    @Override
    public int hashCode() {
        int result = adminId != null ? adminId.hashCode() : 0;
        result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
        result = 31 * result + (adminPassword != null ? adminPassword.hashCode() : 0);
        return result;
    }

    public Integer getAdminId() {

        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
