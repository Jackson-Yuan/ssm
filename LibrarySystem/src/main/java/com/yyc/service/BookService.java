package com.yyc.service;

import com.yyc.dao.BookMapper;
import com.yyc.dao.ReaderMapper;
import com.yyc.entity.Book;
import com.yyc.entity.SearchBook;
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

    /**分页查询返回当前页数合适的books*/
    public List<Book> getQueryPageBooks(SearchBook searchBook){
        /**第一次查询，即从index.jsp发起查询*/
        if  (searchBook.getPage() == null){
            searchBook.setPage(1);
        }
        String tempBookName = searchBook.getBookName();
        String tempAuthorName = searchBook.getAuthorName();
        tempBookName = tempBookName.trim();
        tempAuthorName = tempAuthorName.trim();
        if (tempBookName == null || tempBookName.equals(""))
        {
            tempBookName = "%%";
            searchBook.setBookName(tempBookName);
        }else searchBook.setBookName("%"+tempBookName+"%");

        if (tempAuthorName == null || tempAuthorName.equals(""))
        {
            tempAuthorName = "%%";
            searchBook.setAuthorName(tempAuthorName);
        }else searchBook.setAuthorName("%"+tempAuthorName+"%");
        searchBook.setRecord(5);
        List<Book> books = bookMapper.getPageQuery(searchBook);
        return books;
    }

    public Integer getQueryCount(SearchBook searchBook){
        return bookMapper.getCount(searchBook);
    }


}
