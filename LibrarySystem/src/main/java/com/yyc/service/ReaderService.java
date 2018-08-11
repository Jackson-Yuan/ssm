package com.yyc.service;

import com.yyc.dao.ReaderMapper;
import com.yyc.entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yyc on 2018/8/7.
 */
@Service
public class ReaderService {
    @Autowired
    private ReaderMapper readerMapper;

    public Reader getReader(String idCard){
        return readerMapper.getReader(idCard);
    }

    public void updateReaderInfo(Reader reader){
        readerMapper.updateReader(reader);
    }

    public void insertReaderInfo(Reader reader){
        readerMapper.insertReader(reader);
    }
}
