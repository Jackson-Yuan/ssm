package com.yyc.service;

import com.yyc.dao.BookMapper;
import com.yyc.dao.ReaderBookInfoMapper;
import com.yyc.entity.Book;
import com.yyc.entity.ReaderBookInfo;
import com.yyc.eum.BorrowEnum;
import com.yyc.exception.NoNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by yyc on 2018/8/6.
 */
@Service
public class ReaderBookInfoService {
    @Autowired
    private ReaderBookInfoMapper readerBookInfoMapper;

    @Autowired
    private BookMapper bookMapper;

    @Transactional(rollbackForClassName = "NoNumberException")
    public Book getBookInfo(ReaderBookInfo readerBookInfo){
        Book book = bookMapper.getBook(readerBookInfo.getISBN());

        try {
            if (book.getAvailableNumber() <= 0){
                throw new NoNumberException(BorrowEnum.NO_NUMBER.getStateInfo());
            }
            readerBookInfoMapper.insertRecord(readerBookInfo);
            book = bookMapper.getBook(readerBookInfo.getISBN());
        }catch (NoNumberException e){
            throw e;
        }

        return book;
    }

    public void updateRbInfo(String idCard, String ISBN, Date date){
        readerBookInfoMapper.updateRbReturnDate(date,idCard,ISBN);
    }

}
