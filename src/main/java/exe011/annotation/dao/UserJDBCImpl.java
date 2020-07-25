package exe011.annotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserJDBCImpl implements UserDAO {

    public void triggerUserDAO() {
        System.out.println("User JDBC DAO triggered " );        
    }   
    

}
