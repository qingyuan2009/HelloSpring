package exe011.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import exe011.annotation.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    public void tirggerUserService() {
        System.out.println("User Service triggered ");
        dao.triggerUserDAO();
    }

}
