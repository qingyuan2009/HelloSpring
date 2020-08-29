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
    
    /*�������ԣ�
        1.  ���񴫲���Ϊ�� һ��������һ���������ʱ����ǰ���������ʹ������
            Propagation.REQUIRED  Ĭ��, ʹ�õ����ߵ����� ����ȫ�����������һ��
            Propagation.REQUIRES_NEW  �������ߵ�����������¿���������ʹ�ã� ����ȫ�����񲢲�����
        2.  ����ĸ��뼶�� 
            1 -> ��δ�ύ�����Զ����������δ�ύ������  A�� 50��Ϊ30δ�ύ�� B������AΪ30�� A����rollback�� ��������
            2 -> �����ύ  A�� 50��Ϊ30��δ�ύ�� B������A����Ϊ50�� ����ɲ����ظ���������
            4 -> ���ظ���  A�� ��5�����ݣ� B������5���� C����A�µ�3�����ݣ� B�ظ��������8�����ݣ� �ö�
            8 -> ���л�  A�������ݿ�ʱ�� B���ܲ����� ����Ҫ��A��������ȫ����Ч�ʵ͵�����
                     ��õ��� 2�� �����ύ�� MySQL Ĭ����4�����ظ��� 
        3.  Rollback�� 
            rollbackFor: ��ʲô�쳣����ʱrollback
            rollbackForClassName
            noRollbackFor�� ��ʲô�쳣����ʱ ���ع�
            norollbackForCalssName
        4.  �����ֻ������
            readOnly
                true: ����ֻ���� �û�����ֻ������ݿ���ж�ȡ�� �����޸ģ��������ݿⲻ��������Ż�Ч��
                false�� ��ֻ�� �� Ĭ��
        5.  ����ĳ�ʱ���ã� ǿ�ƻع�֮ǰ���õ�ʱ��
            
    */    
    
    //@Transactional
    //��ʵ��ʹ����AOP�Ĵ���������transaction�Ĳ����� ����commit�� rollback...
    //Ҳ���Ա굽������
    @Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED,
            /* noRollbackFor= {AccountException.class} */ 
            readOnly=false, timeout=3)
    //���buyBook ����һ������CheckOut(username, booklist)���ã���������CheckOut��buyBook���ֳɹ�
    //Ĭ��propagation=Propagation.REQUIRED ����ȫ�����������һ�𣬲�����CheckOut��buyBook���ֳɹ�
    public void buyBook(String username, String isbn) {
        
        /*
         * ģ��timeout
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
