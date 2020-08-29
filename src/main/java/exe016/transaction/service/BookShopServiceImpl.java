package exe016.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import exe016.transaction.dao.BookShopDAO;
import exe016.transaction.exception.AccountException;

@Service("bookShopServiceImpl")
public class BookShopServiceImpl  implements BookShopService{
    
    @Autowired
    private BookShopDAO bookShopDao;
    
    /*事务属性：
        1.  事务传播行为： 一个事务被另一个事务调用时，当前的事务如何使用事务
            Propagation.REQUIRED  默认, 使用调用者的事务， 就是全程事务关联在一起
            Propagation.REQUIRES_NEW  将调用者的事务挂起，重新开启事务来使用， 就是全程事务并不关联
        2.  事务的隔离级别： 
            1 -> 读未提交：可以读到别的事务未提交的数据  A： 50改为30未提交， B：读到A为30， A可能rollback， 会造成脏读
            2 -> 读已提交  A： 50改为30但未提交， B：读到A还是为50， 会造成不可重复读的问题
            4 -> 可重复读  A： 有5条数据， B：读到5条， C插入A新的3条数据， B重复读会读到8条数据， 幻读
            8 -> 串行化  A操作数据库时， B不能操作， 必须要等A结束，安全但有效率低的问题
                     最常用的是 2： 读已提交， MySQL 默认是4：可重复读 
        3.  Rollback： 
            rollbackFor: 当什么异常出现时rollback
            rollbackForClassName
            noRollbackFor： 当什么异常出现时 不回滚
            norollbackForCalssName
        4.  事务的只读设置
            readOnly
                true: 申明只读， 用户申明只会对数据库进行读取， 不会修改，所以数据库不会加锁以优化效率
                false： 非只读 ， 默认
        5.  事务的超时设置： 强制回滚之前设置的时间
            
    */    
    
    //@Transactional
    //其实是使用了AOP的代理来进行transaction的操作， 比如commit， rollback...
    //也可以标到类上面
    @Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED,
            /* noRollbackFor= {AccountException.class} */ 
            readOnly=false, timeout=3)
    //如果buyBook 被另一个事务CheckOut(username, booklist)调用，可以允许CheckOut的buyBook部分成功
    //默认propagation=Propagation.REQUIRED 就是全程事务关联在一起，不允许CheckOut的buyBook部分成功
    public void buyBook(String username, String isbn) {
        
        /*
         * 模拟timeout
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */
        
        int pirce = bookShopDao.findPriceByIsbn(isbn);
        
        bookShopDao.updateStock(isbn);
        
        bookShopDao.updateUserAccount(username, pirce);
        
    }

}
