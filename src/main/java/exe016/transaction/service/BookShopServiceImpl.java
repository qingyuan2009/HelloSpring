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
    
    /*�������ԣ�
        1.  ���񴫲���Ϊ�� һ��������һ���������ʱ����ǰ���������ʹ������
            Propagation.REQUIRED  Ĭ��, ʹ�õ����ߵ����� ����ȫ�����������һ��
            Propagation.REQUIRES_NEW  �������ߵ�����������¿���������ʹ�ã� ����ȫ�����񲢲�����
    */    
    
    //@Transactional
    //��ʵ��ʹ����AOP�Ĵ���������transaction�Ĳ����� ����commit�� rollback...
    //Ҳ���Ա굽������
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    //���buyBook ����һ������CheckOut(username, booklist)���ã���������CheckOut��buyBook���ֳɹ�
    //Ĭ��propagation=Propagation.REQUIRED ����ȫ�����������һ�𣬲�����CheckOut��buyBook���ֳɹ�
    public void buyBook(String username, String isbn) {
        
        int pirce = bookShopDao.findPriceByIsbn(isbn);
        
        bookShopDao.updateStock(isbn);
        
        bookShopDao.updateUserAccount(username, pirce);
        
    }

}
