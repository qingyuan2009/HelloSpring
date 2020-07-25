package exe011.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import exe011.annotation.service.UserService;


/*
 * @Controller的作用： 注意 Bean id 首字母小写
 * 相当于加了 <bean id="userController" class="exe011.annotation.controller.UserController"></bean>
 * 可以更改默认ID值， @Controller("ID值") or  @Controller(value="ID值")
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
