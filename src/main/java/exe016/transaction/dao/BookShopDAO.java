package exe016.transaction.dao;

public interface BookShopDAO {

    public int findPriceByIsbn(String isbn);
    
    public void updateStock(String isbn);
    
    public void updateUserAccount(String username, Integer price);
}
