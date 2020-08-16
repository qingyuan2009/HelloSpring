package exe016.transaction.service;

import java.util.List;

public interface Cashier {
    
    public void CheckOut(String username, List<String> isbn);

}
