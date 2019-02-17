package com.sust.onlineorder.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TShopExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDispatchPayIsNull() {
            addCriterion("dispatch_pay is null");
            return (Criteria) this;
        }

        public Criteria andDispatchPayIsNotNull() {
            addCriterion("dispatch_pay is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchPayEqualTo(Integer value) {
            addCriterion("dispatch_pay =", value, "dispatchPay");
            return (Criteria) this;
        }

        public Criteria andDispatchPayNotEqualTo(Integer value) {
            addCriterion("dispatch_pay <>", value, "dispatchPay");
            return (Criteria) this;
        }

        public Criteria andDispatchPayGreaterThan(Integer value) {
            addCriterion("dispatch_pay >", value, "dispatchPay");
            return (Criteria) this;
        }

        public Criteria andDispatchPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("dispatch_pay >=", value, "dispatchPay");
            return (Criteria) this;
        }

        public Criteria andDispatchPayLessThan(Integer value) {
            addCriterion("dispatch_pay <", value, "dispatchPay");
            return (Criteria) this;
        }

        public Criteria andDispatchPayLessThanOrEqualTo(Integer value) {
            addCriterion("dispatch_pay <=", value, "dispatchPay");
            return (Criteria) this;
        }

        public Criteria andDispatchPayIn(List<Integer> values) {
            addCriterion("dispatch_pay in", values, "dispatchPay");
            return (Criteria) this;
        }

        public Criteria andDispatchPayNotIn(List<Integer> values) {
            addCriterion("dispatch_pay not in", values, "dispatchPay");
            return (Criteria) this;
        }

        public Criteria andDispatchPayBetween(Integer value1, Integer value2) {
            addCriterion("dispatch_pay between", value1, value2, "dispatchPay");
            return (Criteria) this;
        }

        public Criteria andDispatchPayNotBetween(Integer value1, Integer value2) {
            addCriterion("dispatch_pay not between", value1, value2, "dispatchPay");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeIsNull() {
            addCriterion("dispatch_time is null");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeIsNotNull() {
            addCriterion("dispatch_time is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeEqualTo(Integer value) {
            addCriterion("dispatch_time =", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeNotEqualTo(Integer value) {
            addCriterion("dispatch_time <>", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeGreaterThan(Integer value) {
            addCriterion("dispatch_time >", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dispatch_time >=", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeLessThan(Integer value) {
            addCriterion("dispatch_time <", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeLessThanOrEqualTo(Integer value) {
            addCriterion("dispatch_time <=", value, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeIn(List<Integer> values) {
            addCriterion("dispatch_time in", values, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeNotIn(List<Integer> values) {
            addCriterion("dispatch_time not in", values, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeBetween(Integer value1, Integer value2) {
            addCriterion("dispatch_time between", value1, value2, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andDispatchTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("dispatch_time not between", value1, value2, "dispatchTime");
            return (Criteria) this;
        }

        public Criteria andAssessRateIsNull() {
            addCriterion("assess_rate is null");
            return (Criteria) this;
        }

        public Criteria andAssessRateIsNotNull() {
            addCriterion("assess_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAssessRateEqualTo(BigDecimal value) {
            addCriterion("assess_rate =", value, "assessRate");
            return (Criteria) this;
        }

        public Criteria andAssessRateNotEqualTo(BigDecimal value) {
            addCriterion("assess_rate <>", value, "assessRate");
            return (Criteria) this;
        }

        public Criteria andAssessRateGreaterThan(BigDecimal value) {
            addCriterion("assess_rate >", value, "assessRate");
            return (Criteria) this;
        }

        public Criteria andAssessRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("assess_rate >=", value, "assessRate");
            return (Criteria) this;
        }

        public Criteria andAssessRateLessThan(BigDecimal value) {
            addCriterion("assess_rate <", value, "assessRate");
            return (Criteria) this;
        }

        public Criteria andAssessRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("assess_rate <=", value, "assessRate");
            return (Criteria) this;
        }

        public Criteria andAssessRateIn(List<BigDecimal> values) {
            addCriterion("assess_rate in", values, "assessRate");
            return (Criteria) this;
        }

        public Criteria andAssessRateNotIn(List<BigDecimal> values) {
            addCriterion("assess_rate not in", values, "assessRate");
            return (Criteria) this;
        }

        public Criteria andAssessRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("assess_rate between", value1, value2, "assessRate");
            return (Criteria) this;
        }

        public Criteria andAssessRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("assess_rate not between", value1, value2, "assessRate");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceIsNull() {
            addCriterion("dispatch_price is null");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceIsNotNull() {
            addCriterion("dispatch_price is not null");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceEqualTo(BigDecimal value) {
            addCriterion("dispatch_price =", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceNotEqualTo(BigDecimal value) {
            addCriterion("dispatch_price <>", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceGreaterThan(BigDecimal value) {
            addCriterion("dispatch_price >", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dispatch_price >=", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceLessThan(BigDecimal value) {
            addCriterion("dispatch_price <", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dispatch_price <=", value, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceIn(List<BigDecimal> values) {
            addCriterion("dispatch_price in", values, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceNotIn(List<BigDecimal> values) {
            addCriterion("dispatch_price not in", values, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dispatch_price between", value1, value2, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andDispatchPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dispatch_price not between", value1, value2, "dispatchPrice");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceIsNull() {
            addCriterion("salesroom_price is null");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceIsNotNull() {
            addCriterion("salesroom_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceEqualTo(BigDecimal value) {
            addCriterion("salesroom_price =", value, "salesroomPrice");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceNotEqualTo(BigDecimal value) {
            addCriterion("salesroom_price <>", value, "salesroomPrice");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceGreaterThan(BigDecimal value) {
            addCriterion("salesroom_price >", value, "salesroomPrice");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("salesroom_price >=", value, "salesroomPrice");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceLessThan(BigDecimal value) {
            addCriterion("salesroom_price <", value, "salesroomPrice");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("salesroom_price <=", value, "salesroomPrice");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceIn(List<BigDecimal> values) {
            addCriterion("salesroom_price in", values, "salesroomPrice");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceNotIn(List<BigDecimal> values) {
            addCriterion("salesroom_price not in", values, "salesroomPrice");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salesroom_price between", value1, value2, "salesroomPrice");
            return (Criteria) this;
        }

        public Criteria andSalesroomPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salesroom_price not between", value1, value2, "salesroomPrice");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeIsNull() {
            addCriterion("business_time is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeIsNotNull() {
            addCriterion("business_time is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEqualTo(String value) {
            addCriterion("business_time =", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotEqualTo(String value) {
            addCriterion("business_time <>", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeGreaterThan(String value) {
            addCriterion("business_time >", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeGreaterThanOrEqualTo(String value) {
            addCriterion("business_time >=", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeLessThan(String value) {
            addCriterion("business_time <", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeLessThanOrEqualTo(String value) {
            addCriterion("business_time <=", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeLike(String value) {
            addCriterion("business_time like", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotLike(String value) {
            addCriterion("business_time not like", value, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeIn(List<String> values) {
            addCriterion("business_time in", values, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotIn(List<String> values) {
            addCriterion("business_time not in", values, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeBetween(String value1, String value2) {
            addCriterion("business_time between", value1, value2, "businessTime");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeNotBetween(String value1, String value2) {
            addCriterion("business_time not between", value1, value2, "businessTime");
            return (Criteria) this;
        }

        public Criteria andMainPictureIsNull() {
            addCriterion("main_picture is null");
            return (Criteria) this;
        }

        public Criteria andMainPictureIsNotNull() {
            addCriterion("main_picture is not null");
            return (Criteria) this;
        }

        public Criteria andMainPictureEqualTo(String value) {
            addCriterion("main_picture =", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotEqualTo(String value) {
            addCriterion("main_picture <>", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureGreaterThan(String value) {
            addCriterion("main_picture >", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureGreaterThanOrEqualTo(String value) {
            addCriterion("main_picture >=", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureLessThan(String value) {
            addCriterion("main_picture <", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureLessThanOrEqualTo(String value) {
            addCriterion("main_picture <=", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureLike(String value) {
            addCriterion("main_picture like", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotLike(String value) {
            addCriterion("main_picture not like", value, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureIn(List<String> values) {
            addCriterion("main_picture in", values, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotIn(List<String> values) {
            addCriterion("main_picture not in", values, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureBetween(String value1, String value2) {
            addCriterion("main_picture between", value1, value2, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andMainPictureNotBetween(String value1, String value2) {
            addCriterion("main_picture not between", value1, value2, "mainPicture");
            return (Criteria) this;
        }

        public Criteria andAverageIsNull() {
            addCriterion("average is null");
            return (Criteria) this;
        }

        public Criteria andAverageIsNotNull() {
            addCriterion("average is not null");
            return (Criteria) this;
        }

        public Criteria andAverageEqualTo(Integer value) {
            addCriterion("average =", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageNotEqualTo(Integer value) {
            addCriterion("average <>", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageGreaterThan(Integer value) {
            addCriterion("average >", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageGreaterThanOrEqualTo(Integer value) {
            addCriterion("average >=", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageLessThan(Integer value) {
            addCriterion("average <", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageLessThanOrEqualTo(Integer value) {
            addCriterion("average <=", value, "average");
            return (Criteria) this;
        }

        public Criteria andAverageIn(List<Integer> values) {
            addCriterion("average in", values, "average");
            return (Criteria) this;
        }

        public Criteria andAverageNotIn(List<Integer> values) {
            addCriterion("average not in", values, "average");
            return (Criteria) this;
        }

        public Criteria andAverageBetween(Integer value1, Integer value2) {
            addCriterion("average between", value1, value2, "average");
            return (Criteria) this;
        }

        public Criteria andAverageNotBetween(Integer value1, Integer value2) {
            addCriterion("average not between", value1, value2, "average");
            return (Criteria) this;
        }

        public Criteria andMonthPayIsNull() {
            addCriterion("month_pay is null");
            return (Criteria) this;
        }

        public Criteria andMonthPayIsNotNull() {
            addCriterion("month_pay is not null");
            return (Criteria) this;
        }

        public Criteria andMonthPayEqualTo(Integer value) {
            addCriterion("month_pay =", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayNotEqualTo(Integer value) {
            addCriterion("month_pay <>", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayGreaterThan(Integer value) {
            addCriterion("month_pay >", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_pay >=", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayLessThan(Integer value) {
            addCriterion("month_pay <", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayLessThanOrEqualTo(Integer value) {
            addCriterion("month_pay <=", value, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayIn(List<Integer> values) {
            addCriterion("month_pay in", values, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayNotIn(List<Integer> values) {
            addCriterion("month_pay not in", values, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayBetween(Integer value1, Integer value2) {
            addCriterion("month_pay between", value1, value2, "monthPay");
            return (Criteria) this;
        }

        public Criteria andMonthPayNotBetween(Integer value1, Integer value2) {
            addCriterion("month_pay not between", value1, value2, "monthPay");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNull() {
            addCriterion("shop_type is null");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNotNull() {
            addCriterion("shop_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopTypeEqualTo(Integer value) {
            addCriterion("shop_type =", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotEqualTo(Integer value) {
            addCriterion("shop_type <>", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThan(Integer value) {
            addCriterion("shop_type >", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_type >=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThan(Integer value) {
            addCriterion("shop_type <", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThanOrEqualTo(Integer value) {
            addCriterion("shop_type <=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeIn(List<Integer> values) {
            addCriterion("shop_type in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotIn(List<Integer> values) {
            addCriterion("shop_type not in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeBetween(Integer value1, Integer value2) {
            addCriterion("shop_type between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_type not between", value1, value2, "shopType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}