package com.sust.onlineorder.entity;

import java.math.BigDecimal;

public class TShop {
    private Integer id;

    private String shopName;

    private String title;

    private Integer dispatchPay;

    private Integer dispatchTime;

    private BigDecimal assessRate;

    private String address;

    private BigDecimal dispatchPrice;

    private BigDecimal salesroomPrice;

    private String phone;

    private String businessTime;

    private String mainPicture;

    private Integer average;

    private Integer monthPay;

    private Integer shopType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getDispatchPay() {
        return dispatchPay;
    }

    public void setDispatchPay(Integer dispatchPay) {
        this.dispatchPay = dispatchPay;
    }

    public Integer getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Integer dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public BigDecimal getAssessRate() {
        return assessRate;
    }

    public void setAssessRate(BigDecimal assessRate) {
        this.assessRate = assessRate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public BigDecimal getDispatchPrice() {
        return dispatchPrice;
    }

    public void setDispatchPrice(BigDecimal dispatchPrice) {
        this.dispatchPrice = dispatchPrice;
    }

    public BigDecimal getSalesroomPrice() {
        return salesroomPrice;
    }

    public void setSalesroomPrice(BigDecimal salesroomPrice) {
        this.salesroomPrice = salesroomPrice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime == null ? null : businessTime.trim();
    }

    public String getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture == null ? null : mainPicture.trim();
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public Integer getMonthPay() {
        return monthPay;
    }

    public void setMonthPay(Integer monthPay) {
        this.monthPay = monthPay;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    @Override
    public String toString() {
        return "TShop{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", title='" + title + '\'' +
                ", dispatchPay=" + dispatchPay +
                ", dispatchTime=" + dispatchTime +
                ", assessRate=" + assessRate +
                ", address='" + address + '\'' +
                ", dispatchPrice=" + dispatchPrice +
                ", salesroomPrice=" + salesroomPrice +
                ", phone='" + phone + '\'' +
                ", businessTime='" + businessTime + '\'' +
                ", mainPicture='" + mainPicture + '\'' +
                ", average=" + average +
                ", monthPay=" + monthPay +
                ", shopType=" + shopType +
                '}';
    }
}