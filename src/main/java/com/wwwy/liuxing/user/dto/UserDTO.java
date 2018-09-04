package com.wwwy.liuxing.user.dto;

import java.io.Serializable;

/**
 *用户实体类
 * @author W1665
 * @date 2018/4/10
 */
public class UserDTO implements Serializable {

    public static final long serialVersionUID=1L;
    /**
     * 用户id,主键
     */
    private Integer userId;
    /**
     * 用户登录名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户名称
     */
    private String userRealName;
    /**
     * 用户手机号
     */
    private String userTel;

    public UserDTO() {
    }

    public UserDTO(Integer userId, String userName, String userPassword, String userRealName, String userTel) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRealName = userRealName;
        this.userTel = userTel;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userTel='" + userTel + '\'' +
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

        UserDTO userDTO = (UserDTO) o;

        if (userId != null ? !userId.equals(userDTO.userId) : userDTO.userId != null) {
            return false;
        }
        if (userName != null ? !userName.equals(userDTO.userName) : userDTO.userName != null) {
            return false;
        }
        if (userPassword != null ? !userPassword.equals(userDTO.userPassword) : userDTO.userPassword != null) {
            return false;
        }
        return userRealName != null ? userRealName.equals(userDTO.userRealName) : userDTO.userRealName == null && (userTel != null ? userTel.equals(userDTO.userTel) : userDTO.userTel == null);

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userRealName != null ? userRealName.hashCode() : 0);
        result = 31 * result + (userTel != null ? userTel.hashCode() : 0);
        return result;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
}
