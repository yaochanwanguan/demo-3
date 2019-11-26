package com.datangedu.cn.model.sysUser;

import java.util.Date;

public class OrderList {
    private int id;

    private String orderNumber;

    private String userBuy;

    private String orderContent;

    private Integer buySum;

    private String img;

    private Double orderMount;

    private String createTime;

    private Integer payType;

    private Integer status;

    private String evaluate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUserBuy() {
        return userBuy;
    }

    public void setUserBuy(String userBuy) {
        this.userBuy = userBuy;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public Integer getBuySum() {
        return buySum;
    }

    public void setBuySum(Integer buySum) {
        this.buySum = buySum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getOrderMount() {
        return orderMount;
    }

    public void setOrderMount(Double orderMount) {
        this.orderMount = orderMount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }
}