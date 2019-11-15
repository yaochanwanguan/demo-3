package com.datangedu.cn.model.sysUser;

public class ProviderImg {
    private String id;

    private String serviceId;

    private Integer buyNum;

    private String serviceName;

    private Integer unitPrice;

    private Integer sum;

    private String providerId;

    private String providerName;

    private String userName;

    private byte[] productPicture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId == null ? null : providerId.trim();
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public byte[] getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(byte[] productPicture) {
        this.productPicture = productPicture;
    }
}