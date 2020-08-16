package exe016.transaction.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import exe016.transaction.dao.BookShopDAO;
import exe016.transaction.service.BookShopService;
import exe016.transaction.service.Cashier;

public class BookShopTest {
    
    @Autowired
    private BookShopService bookShopService;
    
    @Autowired
    private Cashier cashier;
    
    @Autowired
    private BookShopDAO bookShopDAO;
    
    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-transaction.xml");
        bookShopService =  context.getBean("bookShopServiceImpl", BookShopService.class);
        bookShopDAO = context.getBean("bookShopADOImpl", BookShopDAO.class);
        cashier =  context.getBean("cashierImpl", Cashier.class);
    }
    
    //@Test
    public void TestTransaction() {
        try {
            //ע���򵥱�����ʹ����service��ʹ����@Transactional
            bookShopService.buyBook("Tom", "ISBN-001");
        } catch(Exception e){
            e.printStackTrace();
        }        
    }    

    //@Test
    public void TestCheckOut() {
        try {
            List<String> booklist = new ArrayList<String>();
            booklist.add("ISBN-001");
            booklist.add("ISBN-002"); 
            //���CheckOut�в���transactional�Ļ����ᵼ�²��ֳɹ�������ʧ��
            //��Ϊtransactional֮ǰֻ�������򵥱����ϣ� e.g.bookShopService.buyBook("Tom", "ISBN-001");
            //����Ҫע��buyBook�����񴫲���Ϊ��Propagation.REQUIRES_NEW�� Propagation.REQUIRED
            cashier.CheckOut("Tom", booklist);
        } catch(Exception e){
            e.printStackTrace();
        }        
    }

}
