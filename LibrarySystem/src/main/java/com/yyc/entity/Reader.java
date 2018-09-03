package com.yyc.entity;

import java.util.Date;

/**
 * Created by yyc on 2018/8/3.
 */
public class Reader {
    private String idCard;

    private String name;

    private Integer age;

    private String gender;

    private Boolean cardState;

    private Date cardDate;

    private String pictureUrl;

    public Reader() {
    }

    public Reader(String idCard, String name, Integer age, String gender, Boolean cardState, Date cardDate) {
        this.idCard = idCard;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.cardState = cardState;
        this.cardDate = cardDate;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getCardState() {
        return cardState;
    }

    public void setCardState(Boolean cardState) {
        this.cardState = cardState;
    }

    public Date getCardDate() {
        return cardDate;
    }

    public void setCardDate(Date cardDate) {
        this.cardDate = cardDate;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", cardState=" + cardState +
                ", cardDate=" + cardDate +
                '}';
    }
}
