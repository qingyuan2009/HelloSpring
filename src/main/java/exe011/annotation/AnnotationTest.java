package exe011.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exe011.annotation.controller.UserController;
import exe011.annotation.dao.UserDAO;
import exe011.annotation.service.UserService;

public class AnnotationTest {
    
    //@Test
    /*public void testAnnotation() {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotation.xml");
       
        //autowire by annotation
        UserController uc = context.getBean("userController", UserController.class);
        System.out.println("user controller:" +  uc);
        
        UserService us = context.getBean("userServiceImpl", UserService.class);
        System.out.println("user service:" +  us);
        
        //不能实例的话，因为被排除了
        UserDAO dao = context.getBean("userJDBCImpl", UserDAO.class);
        System.out.println("user dao:" +  dao);
        
    }*/
    
    @Test
    public void testAnnotation() {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotation.xml");
       
        //Auto-wired by annotation
        UserController uc = context.getBean("userController", UserController.class);
        System.out.println("user controller:" +  uc);   
        
        uc.triggerController();        
        
    }
    
    

}
