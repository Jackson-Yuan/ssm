package com.yyc.controller;

import com.yyc.entity.Book;
import com.yyc.entity.Reader;
import com.yyc.entity.Result;
import com.yyc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by yyc on 2018/8/4.
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/bookshow")
    public String showBook(@RequestParam(value = "bookName",required = false) String bookName, @RequestParam(value = "bookAuthor",required = false) String bookAuthor, Map<String,Object> map){
        List<Book> books = null;
        if (bookName == null || bookAuthor == null){
            if (bookName == null) bookName = "%%";
            if (bookAuthor == null) bookAuthor = "%%";
            books = bookService.showBook(bookName,bookAuthor);
        }else{
            bookName = "%"+bookName+"%";
            bookAuthor = "%"+bookAuthor+"%";
            books = bookService.showBook(bookName,bookAuthor);
        }
        map.put("books",books);
        return "bookList";
    }

    @ResponseBody
    @RequestMapping("/ajaxvalidatebook")
    public Result<String> validateBook(HttpSession session){
        Reader reader = (Reader) session.getAttribute("loginReader");
        if (reader != null) return new Result<>(true,"","");
        else return new Result<>(false,"","");

    }

    @RequestMapping("/returnbookinfo")
    public String returnBookInfo(@RequestParam("idCard") String id, Model model){
        List<Book> books = bookService.getBorrowedBooksInfo(id);
        model.addAttribute("books",books);
        return "selectBook";
    }
}
