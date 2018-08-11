package test;

import com.yyc.dao.ReaderMapper;
import com.yyc.entity.Reader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by yyc on 2018/8/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml" })
public class ReaderTest {
    @Autowired
    private ReaderMapper readerMapper;

    @Test
    public void testGetReader(){
        System.out.println(readerMapper.getReader("10009"));
    }

    @Test
    public void insert(){
        Date date = new Date(2018,8,9,22,13,30);
        Reader reader = new Reader("100011","ghj",19,"男",true,date);
        try {
            readerMapper.insertReader(reader);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
