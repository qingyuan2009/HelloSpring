package exe016.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import exe016.transaction.exception.AccountException;
import exe016.transaction.exception.BookStockException;

@Repository("bookShopADOImpl")
public class BookShopDAOImpl implements BookShopDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;  

    public int findPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn = ? ";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);         
    }

    public void updateStock(String isbn) {
        String sql = "select stock from book_stock where isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);   
        
        if (stock <= 0) {
            throw new BookStockException("¿â´æ²»×ã");
        }
        
        sql = "update book_stock set stock = stock -1 where isbn = ?";
        jdbcTemplate.update(sql, isbn);

    }  

    public void updateUserAccount(String username, Integer price) {
        String sql = "select balance from account where username = ?";
        int balance = jdbcTemplate.queryForObject(sql, Integer.class, username);   
        
        if (balance < price) {
            throw new AccountException("Óà¶î²»×ã");
        }
        
        sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql, price, username);        
    }

}
