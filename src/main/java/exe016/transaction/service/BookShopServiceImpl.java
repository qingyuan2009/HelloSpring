package exe016.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import exe016.transaction.dao.BookShopDAO;

@Service("bookShopServiceImpl")
public class BookShopServiceImpl  implements BookShopService{
    
    @Autowired
    private BookShopDAO bookShopDao;
    
    /*事务属性：
        1.  事务传播行为： 一个事务被另一个事务调用时，当前的事务如何使用事务
            Propagation.REQUIRED  默认, 使用调用者的事务， 就是全程事务关联在一起
            Propagation.REQUIRES_NEW  将调用者的事务挂起，重新开启事务来使用， 就是全程事务并不关联
    */    
    
    //@Transactional
    //其实是使用了AOP的代理来进行transaction的操作， 比如commit， rollback...
    //也可以标到类上面
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    //如果buyBook 被另一个事务CheckOut(username, booklist)调用，可以允许CheckOut的buyBook部分成功
    //默认propagation=Propagation.REQUIRED 就是全程事务关联在一起，不允许CheckOut的buyBook部分成功
    public void buyBook(String username, String isbn) {
        
        int pirce = bookShopDao.findPriceByIsbn(isbn);
        
        bookShopDao.updateStock(isbn);
        
        bookShopDao.updateUserAccount(username, pirce);
        
    }

}
