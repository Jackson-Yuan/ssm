package com.yyc.entity;

import java.util.Date;

/**
 * Created by yyc on 2018/8/3.
 */
public class ReaderBookInfo {
    private String idCard;

    private String ISBN;

    private Date borrowingDate;

    private Date returnDate;

    public ReaderBookInfo() {
    }

    public ReaderBookInfo(String idCard, String ISBN, Date borrowingDate, Date returnDate) {
        this.idCard = idCard;
        this.ISBN = ISBN;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "ReaderBookInfo{" +
                "idCard='" + idCard + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", borrowingDate=" + borrowingDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
