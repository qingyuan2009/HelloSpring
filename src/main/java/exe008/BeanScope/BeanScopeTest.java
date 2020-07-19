package exe008.BeanScope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeTest {

    @Test
    public void testCar() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanCarScope.xml");

        // 默认是singleton, 构造器只创建一次
        Car2 car = context.getBean("Car", Car2.class);
        Car2 car2 = context.getBean("Car", Car2.class);
        System.out.println(car == car2);        
        
        /*result
        Invoke Car2 constructor
        true
        */
        
        
        // scope = prototype, 构造器会创建多次
        Car2 car3 = context.getBean("Car2", Car2.class);
        Car2 car4 = context.getBean("Car2", Car2.class);
        System.out.println(car3 == car4);  
        
        /*result
        Invoke Car2 constructor
        Invoke Car2 constructor
        false
        */
        
        //还有另两种scope: request and session, 作用在http
        // request: 一次请求对应一个bean
        // session: 一次会话对应一个Bean， what is session: 一次会话的多次请求可以共享数据
       
     
    }

}
