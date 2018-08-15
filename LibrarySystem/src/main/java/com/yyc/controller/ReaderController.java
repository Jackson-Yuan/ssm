package com.yyc.controller;

import com.yyc.entity.Reader;
import com.yyc.entity.Result;
import com.yyc.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by yyc on 2018/8/8.
 */
@Controller
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    /**提交之前验证卡号是否存在*/
    @RequestMapping("/ajaxvalidateidCard")
    @ResponseBody
    public Result<String> validateReader(@RequestParam(value = "idCard",required = false) String idCard){
        if (idCard != null){
            Reader reader = readerService.getReader(idCard);
            if (reader == null) return new Result<>(false,"借阅卡不存在",null);
        }
        return null;
    }

    /**登录*/
    /**sessionattribute少用，销毁session里面的数据销毁不了，可能更springmvc流程有关*/
    @RequestMapping("/readershow")
    public String getReaderInfo(@RequestParam(value = "readerCard",required = false) String idCard, Map<String,Object> map,HttpSession session){
        if (idCard != null){
            Reader reader = readerService.getReader(idCard);
            map.put("loginReader",reader);
            session.setAttribute("loginReader",reader);
        }
        return "readerShow";
    }

    /**编辑读者信息*/
    @RequestMapping("/editReader")
    public String editReaderInfo(@RequestParam("idCard") String id,Map<String,Object> map){
        Reader reader = readerService.getReader(id);
        map.put("reader",reader);
        return "edit";
    }

    @ModelAttribute
    public void getEditReader(@RequestParam(value = "editCard",required = false) String idCard,Map<String,Object> map){
        if (idCard != null){
            Reader reader = readerService.getReader(idCard);
            map.put("editReader",reader);
        }
    }

    /**模型数据机制流程 到这个目标方法前不多赘述
     * 取得匹配键的对象，与前台传过来的参数进行匹配，会对值进行覆盖，注意此处是editCard，不会对idcard覆盖，其余均覆盖
     * */
    @RequestMapping("/completeReader")
    public String completeEditReader(@ModelAttribute("editReader") Reader reader, Model model){
        model.addAttribute("reader",reader);
        readerService.updateReaderInfo(reader);
        return "readerShow";
    }

    /**注册*/
    @ResponseBody
    @RequestMapping("/registerReader")
    public Result<String> insertReader(Reader reader){
        Result<String> result = null;
        try {
            readerService.insertReaderInfo(reader);
            result = new Result<>(true,"注册成功","hhhhhhh");
        }catch (Exception e){
            result = new Result<>(false,"注册失败","hhhhh");
        }

        return result;
    }

    /**注销*/
    @ResponseBody
    @RequestMapping("/cancellationReader")
    public Result deleteSessionReader(HttpSession httpSession)
    {
        httpSession.invalidate();
        return null;
    }
}
