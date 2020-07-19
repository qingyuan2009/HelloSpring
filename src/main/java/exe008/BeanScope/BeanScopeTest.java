package exe008.BeanScope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeTest {

    @Test
    public void testCar() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanCarScope.xml");

        // Ĭ����singleton, ������ֻ����һ��
        Car2 car = context.getBean("Car", Car2.class);
        Car2 car2 = context.getBean("Car", Car2.class);
        System.out.println(car == car2);        
        
        /*result
        Invoke Car2 constructor
        true
        */
        
        
        // scope = prototype, �������ᴴ�����
        Car2 car3 = context.getBean("Car2", Car2.class);
        Car2 car4 = context.getBean("Car2", Car2.class);
        System.out.println(car3 == car4);  
        
        /*result
        Invoke Car2 constructor
        Invoke Car2 constructor
        false
        */
        
        //����������scope: request and session, ������http
        // request: һ�������Ӧһ��bean
        // session: һ�λỰ��Ӧһ��Bean�� what is session: һ�λỰ�Ķ��������Թ�������
       
     
    }

}
