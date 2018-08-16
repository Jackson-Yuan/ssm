package com.yyc.dao;

import com.yyc.entity.Book;
import com.yyc.entity.SearchBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yyc on 2018/8/3.
 */
public interface BookMapper {
    List<Book> getAllBooks(@Param("bookName")String bookInfo,@Param("authorName")String authorInfo);

    Book getBook(String ISBN);

    int getCount(SearchBook searchBook);

    List<Book> getPageQuery(SearchBook searchBook);
}
