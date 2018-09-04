package com.yyc.controller;

import com.yyc.entity.Reader;
import com.yyc.exception.IllegalException;
import com.yyc.service.FileService;
import com.yyc.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by yyc on 2018/8/18.
 */
@Controller
public class FileController {
    private static final String targetPrefix = "F:\\java\\LibrarySystem\\targetfile\\";
    private static final String tempPrefix = "F:\\java\\LibrarySystem\\tempfile";

    @Autowired
    private FileService fileService;

    @Autowired
    private ReaderService readerService;

    @RequestMapping("/file")
    public String processUpload(HttpServletRequest request, Model model) throws IOException {
        Reader reader = null;
        try {
            reader = fileService.processUpload(request, tempPrefix, targetPrefix);
        }catch (IllegalException e){
            model.addAttribute("wrongMessage",e.getMessage());
            return "editpicture";
        }

        model.addAttribute("reader", reader);
        request.getSession().setAttribute("loginReader", reader);
        readerService.updateReaderInfo(reader);
        return "edit";
    }
}
