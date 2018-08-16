package test;

import com.yyc.dao.BookMapper;
import com.yyc.entity.SearchBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yyc on 2018/8/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-web.xml" })
public class BookTest {
    @Autowired
    BookMapper bookMapper;

    @Test
    public void testGetAll(){
        System.out.println(bookMapper.getAllBooks("%%","%%"));
    }

    @Test
    public void testGetBook(){
        System.out.println(bookMapper.getBook("9787111511632"));
    }

    @Test
    public void testGetCount(){
//        int sum=bookMapper.getCount();
//        System.out.println(sum);
        SearchBook searchBook = new SearchBook("%%","%%",1,2);
        System.out.println(bookMapper.getCount(searchBook));
    }

    @Test
    public void testQueryPage(){
        SearchBook searchBook = new SearchBook("%计算机%",null,1,2);
        System.out.println(bookMapper.getPageQuery(searchBook));
    }
}
