package exe011.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import exe011.annotation.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required=false)  // required=false, ���b����b�䣬����Ҳ���󮐳�
    @Qualifier("userJDBCImpl")  //���Ԅ��b����ָ����Ҫ�b������
    private UserDAO dao;
    
    //@Autowired(required=false)  // required=false, ���b����b�䣬����Ҳ���󮐳�
    //@Qualifier("userJDBCImpl")  //���Ԅ��b����ָ����Ҫ�b������
    // Annotation���d��set ������Ҳ���ԣ���setter�����䌍�ǿ���ʡ�Ե�
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public void tirggerUserService() {
        System.out.println("User Service triggered ");
        dao.triggerUserDAO();
    }

}
