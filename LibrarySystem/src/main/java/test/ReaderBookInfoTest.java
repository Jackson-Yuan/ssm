package test;

import com.yyc.dao.ReaderBookInfoMapper;
import com.yyc.entity.ReaderBookInfo;
import com.yyc.exception.NoNumberException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by yyc on 2018/8/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml" })
public class ReaderBookInfoTest {
    @Autowired
    ReaderBookInfoMapper readerBookInfoMapper;

    @Test
    public void testInsert(){
        Date date1 = new Date(2018,5,26,19,04,10);
        Date date2 = new Date(2018,6,14,19,4,10);
        ReaderBookInfo readerBookInfo = new ReaderBookInfo(null,"9787111511632",date1,date2);
        readerBookInfoMapper.insertRecord(readerBookInfo);
    }

    @Test
    @Transactional(rollbackForClassName = "NoNumberException")
    public void testTranscational (){
        try {
            Date date1 = new Date(2018,5,26,19,04,10);
            Date date2 = new Date(2018,6,14,19,4,10);
            ReaderBookInfo readerBookInfo = new ReaderBookInfo(null,"9787111511632",date1,date2);
            readerBookInfoMapper.insertRecord(readerBookInfo);
            throw new NoNumberException("hhhhhhhhh");
        }catch (NoNumberException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testUpdate(){
        Date date2 = new Date(2018,6,14,19,4,10);
        readerBookInfoMapper.updateRbReturnDate(date2,"10009","9787302479499");
    }
}
