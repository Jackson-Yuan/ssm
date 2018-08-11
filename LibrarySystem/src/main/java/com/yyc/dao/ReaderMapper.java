package com.yyc.dao;

import com.yyc.entity.Reader;

/**
 * Created by yyc on 2018/8/6.
 */
public interface ReaderMapper {
    Reader getReader(String idCard);

    void updateReader(Reader reader);

    void insertReader(Reader reader);
}
