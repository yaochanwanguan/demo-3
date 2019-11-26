package com.datangedu.cn.model.sysUser;

import java.util.Arrays;
import java.util.Date;

public class Administrator {
    private String id;

    private String userName;

    private String password;

    private String email;

    private String cellphone;

    private Integer status;

    private Date registerTime;

    private String province;

    private String city;

    private String area;

    private String qurenpassword;

    private byte[] headImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getQurenpassword() {
        return qurenpassword;
    }

    public void setQurenpassword(String qurenpassword) {
        this.qurenpassword = qurenpassword;
    }

    public byte[] getHeadImg() {
        return headImg;
    }

    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", status=" + status +
                ", registerTime=" + registerTime +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", qurenpassword='" + qurenpassword + '\'' +
                ", headImg=" + Arrays.toString(headImg) +
                '}';
    }
}