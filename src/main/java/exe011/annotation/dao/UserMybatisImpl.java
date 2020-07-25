package exe011.annotation.dao;

import org.springframework.stereotype.Repository;

/*
 * Important: 如果有兩個實現，需要在注釋中加入ID
 * 這個ID和Autowired中的attribute要同名
 * 自動裝配時， 先根據byType找到兩個實現類，然後再看有沒有byName的匹配
 */

@Repository("dao")
public class UserMybatisImpl implements UserDAO {

    public void triggerUserDAO() {
        System.out.println("User Mybatis DAO triggered " );        
    }   
    

}
