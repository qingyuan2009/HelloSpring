package exe016.transaction.test;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import exe016.transaction.dao.BookShopDAO;
import exe016.transaction.service.BookShopService;

public class BookShopTest {
    
    @Autowired
    private BookShopService bookShopService;
    
    @Autowired
    private BookShopDAO bookShopDAO;
    
    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-transaction.xml");
        bookShopService =  context.getBean("bookShopServiceImpl", BookShopService.class);
        bookShopDAO = context.getBean("bookShopADOImpl", BookShopDAO.class);
    }
    
    @Test
    public void TestTransaction() {
        try {
            //注意使用了service中使用了@Transactional
            bookShopService.buyBook("Tom", "ISBN-001");
        } catch(Exception e){
            e.printStackTrace();
        }        
    }

}
