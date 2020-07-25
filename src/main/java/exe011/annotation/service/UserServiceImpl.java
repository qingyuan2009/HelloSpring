package exe011.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import exe011.annotation.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required=false)  // required=false, 能裝配就裝配，不行也不報異常
    @Qualifier("userJDBCImpl")  //在自動裝配是指定需要裝配的類名
    private UserDAO dao;
    
    //@Autowired(required=false)  // required=false, 能裝配就裝配，不行也不報異常
    //@Qualifier("userJDBCImpl")  //在自動裝配是指定需要裝配的類名
    // Annotation加載在set 方法上也可以，但setter方法其實是可以省略的
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public void tirggerUserService() {
        System.out.println("User Service triggered ");
        dao.triggerUserDAO();
    }

}
