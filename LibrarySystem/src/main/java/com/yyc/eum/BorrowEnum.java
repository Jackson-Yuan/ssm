package com.yyc.eum;

/**
 * Created by yyc on 2018/8/7.
 */
public enum BorrowEnum {
    SUCCESS(1,"借阅成功"),
    NO_NUMBER(2,"库存不足"),
    OVERFLOW_NUMBER(3,"超出借阅总数");

    private int state;

    private String stateInfo;

    private BorrowEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
