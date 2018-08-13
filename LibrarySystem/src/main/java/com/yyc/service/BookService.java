package com.yyc.service;

import com.yyc.dao.BookMapper;
import com.yyc.dao.ReaderMapper;
import com.yyc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yyc on 2018/8/4.
 */
@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ReaderMapper readerMapper;

    public List<Book> showBook(String bookInfo, String authorInfo){
        List<Book> books = null;
        books = bookMapper.getAllBooks(bookInfo,authorInfo);
        return books;
    }

    public Book getBook(String ISBN){
       return bookMapper.getBook(ISBN);
    }


    public List<Book> getBorrowedBooksInfo(String idCard){
        List<Book> books = readerMapper.getBorrowedBooks(idCard);
        return books;
    }

}
