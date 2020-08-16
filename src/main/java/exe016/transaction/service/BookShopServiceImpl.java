package exe016.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exe016.transaction.dao.BookShopDAO;

@Service("bookShopServiceImpl")
public class BookShopServiceImpl  implements BookShopService{
    
    @Autowired
    private BookShopDAO bookShopDao;
    
    @Transactional
    //��ʵ��ʹ����AOP�Ĵ���������transaction�Ĳ����� ����commit�� rollback...
    //Ҳ���Ա굽������
    public void buyBook(String username, String isbn) {
        
        int pirce = bookShopDao.findPriceByIsbn(isbn);
        
        bookShopDao.updateStock(isbn);
        
        bookShopDao.updateUserAccount(username, pirce);
        
    }

}
