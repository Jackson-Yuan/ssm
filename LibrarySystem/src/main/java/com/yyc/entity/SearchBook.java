package com.yyc.entity;

/**
 * Created by yyc on 2018/8/16.
 */
public class SearchBook {
    private String bookName;

    private String authorName;

    private Integer page;

    private Integer record;

    private Integer sumPage;

    public SearchBook() {
    }

    public SearchBook(String bookName, String authorName, Integer page, Integer record) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.page = page;
        this.record = record;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRecord() {
        return record;
    }

    public void setRecord(Integer record) {
        this.record = record;
    }

    public Integer getSumPage() {
        return sumPage;
    }

    public void setSumPage(Integer sumPage) {
        this.sumPage = sumPage;
    }

    @Override
    public String toString() {
        return "SearchBook{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", page=" + page +
                ", record=" + record +
                '}';
    }
}
