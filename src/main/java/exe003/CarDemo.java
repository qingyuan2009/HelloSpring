package exe003;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarDemo {

    @Test
    public void testCar() {        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanCar.xml");

        // ͨ��Bean ID ��ȡBean����
        Car car =  context.getBean("Car", Car.class);       
        System.out.println(car.toString());
        
        Car car2 =  context.getBean("Car2", Car.class);       
        System.out.println(car2.toString());     
    }
    
    @Test
    public void testPerson2() {        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanCar.xml");

        // ͨ��Bean ID ��ȡBean����
        Person2 person =  context.getBean("person2", Person2.class);       
        System.out.println(person.toString());
            
    }


}
