package com.yyc.dao;

import com.yyc.entity.Book;
import com.yyc.entity.Reader;

import java.util.List;

/**
 * Created by yyc on 2018/8/6.
 */
public interface ReaderMapper {
    Reader getReader(String idCard);

    void updateReader(Reader reader);

    void insertReader(Reader reader);

    List<Book> getBorrowedBooks(String idCard);
}
