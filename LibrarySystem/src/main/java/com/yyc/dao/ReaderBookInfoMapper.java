package com.yyc.dao;

import com.yyc.entity.ReaderBookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by yyc on 2018/8/6.
 */
public interface ReaderBookInfoMapper {
    void insertRecord(ReaderBookInfo readerBookInfo);
    void updateRbReturnDate(@Param("returnDate")Date returnDate, @Param("idCard")String idCard ,@Param("ISBN") String ISBN);
}
