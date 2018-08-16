package com.yyc.controller;

import com.yyc.entity.Book;
import com.yyc.entity.Reader;
import com.yyc.entity.Result;
import com.yyc.entity.SearchBook;
import com.yyc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yyc on 2018/8/4.
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

//    @RequestMapping("/bookshow")
//    public String showBook(@RequestParam(value = "bookName",required = false) String bookName, @RequestParam(value = "bookAuthor",required = false) String bookAuthor, Map<String,Object> map){
//        List<Book> books = null;
//        if (bookName == null || bookAuthor == null){
//            if (bookName == null) bookName = "%%";
//            if (bookAuthor == null) bookAuthor = "%%";
//            books = bookService.showBook(bookName,bookAuthor);
//        }else{
//            bookName = "%"+bookName+"%";
//            bookAuthor = "%"+bookAuthor+"%";
//            books = bookService.showBook(bookName,bookAuthor);
//        }
//        map.put("books",books);
//        return "bookList";
//    }

    @RequestMapping("/bookshow")
    public String showBook(SearchBook searchBook,Model model){
        model.addAttribute("books",bookService.getQueryPageBooks(searchBook));
        int sum = bookService.getQueryCount(searchBook);
        if (sum%5 == 0) sum = sum/5;
        else sum = sum/5 + 1;
        /**此时的bookName与authorName带有百分号，如果直接放置在booklist.jsp页面中当做请求参数，则会接收到null 不会有%%
         * 会在bookService的方法报空指针异常，应该在转发前将%%去除
         * */
        searchBook.setSumPage(sum);
        String temp = searchBook.getBookName();
        temp = temp.substring(1,temp.length()-1);
        searchBook.setBookName(temp);
        temp = searchBook.getAuthorName();
        temp = temp.substring(1,temp.length()-1);
        searchBook.setAuthorName(temp);

        model.addAttribute("queryInfo",searchBook);
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
