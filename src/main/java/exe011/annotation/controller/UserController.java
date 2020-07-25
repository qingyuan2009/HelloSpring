package exe011.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import exe011.annotation.service.UserService;


/*
 * @Controller�����ã� ע�� Bean id ����ĸСд
 * �൱�ڼ��� <bean id="userController" class="exe011.annotation.controller.UserController"></bean>
 * ���Ը���Ĭ��IDֵ�� @Controller("IDֵ") or  @Controller(value="IDֵ")
 */

@Controller
public class UserController {
    
    @Autowired
    private UserService us;  
    
    public void triggerController() {
        System.out.println("User Controller triggered ");
        us.tirggerUserService();        
    }
    
}
