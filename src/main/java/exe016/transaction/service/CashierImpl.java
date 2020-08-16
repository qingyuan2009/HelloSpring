package exe016.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashierImpl")
public class CashierImpl implements Cashier {

    @Autowired
    BookShopService bookShopService;

    @Transactional
    //如果不放transactional的话，会导致部分成功，部分失败
    public void CheckOut(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.buyBook(username, isbn);
        }
    }

}
