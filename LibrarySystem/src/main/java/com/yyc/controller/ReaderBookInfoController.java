package com.yyc.controller;

import com.yyc.entity.Book;
import com.yyc.entity.ReaderBookInfo;
import com.yyc.entity.Result;
import com.yyc.eum.BorrowEnum;
import com.yyc.exception.NoNumberException;
import com.yyc.service.BookService;
import com.yyc.service.ReaderBookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yyc on 2018/8/6.
 */
@Controller
public class ReaderBookInfoController {
    @Autowired
    private ReaderBookInfoService readerBookInfoService;

    @Autowired
    private BookService bookService;

    @ResponseBody
    @RequestMapping("/borrowBook")
    public Result<Book> borrowBookInfo(ReaderBookInfo readerBookInfo){
        Book book = bookService.getBook(readerBookInfo.getISBN());

        try {
            book = readerBookInfoService.getBookInfo(readerBookInfo);
        }catch (NoNumberException e){
            return new Result<>(false,book,e.getMessage());
        }
        return new Result<>(true,book,BorrowEnum.SUCCESS.getStateInfo());
//        Book book = null;
//        readerBookInfoService.insertRecord(readerBookInfo);
//        String ISBN = readerBookInfo.getISBN();
//        book = bookService.getBook(ISBN);
//        return new Result<>(true,book, BorrowEnum.SUCCESS.getStateInfo());
    }
}
