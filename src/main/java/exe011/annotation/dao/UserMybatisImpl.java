package exe011.annotation.dao;

import org.springframework.stereotype.Repository;

/*
 * Important: ����Ѓɂ����F����Ҫ��ע��м���ID
 * �@��ID��Autowired�е�attributeҪͬ��
 * �Ԅ��b��r�� �ȸ���byType�ҵ��ɂ����F�Ȼ���ٿ��Л]��byName��ƥ��
 */

@Repository("dao")
public class UserMybatisImpl implements UserDAO {

    public void triggerUserDAO() {
        System.out.println("User Mybatis DAO triggered " );        
    }   
    

}
