package com.yyc.entity;

import java.util.Date;

/**
 * Created by yyc on 2018/8/3.
 */
public class Book {
    private String ISBN;

    private String title;

    private String author;

    private String press;

    private Integer borrowingNumber;

    private Integer totalNumber;

    private Integer availableNumber;

    private String type;

    private Date joinTime;

    public Book() {
    }

    public Book(String ISBN, String title, String author, String press, Integer borrowingNumber, Integer totalNumber, Integer availableNumber, String type, Date joinTime) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.press = press;
        this.borrowingNumber = borrowingNumber;
        this.totalNumber = totalNumber;
        this.availableNumber = availableNumber;
        this.type = type;
        this.joinTime = joinTime;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Integer getBorrowingNumber() {
        return borrowingNumber;
    }

    public void setBorrowingNumber(Integer borrowingNumber) {
        this.borrowingNumber = borrowingNumber;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getAvailableNumber() {
        return availableNumber;
    }

    public void setAvailableNumber(Integer availableNumber) {
        this.availableNumber = availableNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", borrowingNumber=" + borrowingNumber +
                ", totalNumber=" + totalNumber +
                ", availableNumber=" + availableNumber +
                ", type='" + type + '\'' +
                ", joinTime=" + joinTime +
                '}';
    }
}
