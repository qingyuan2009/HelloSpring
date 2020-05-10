package exe003;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarDemo {

    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanCar.xml");

        // ͨ��Bean ID ��ȡBean����
        Car car =  context.getBean("Car", Car.class);       
        System.out.println(car.toString());
        
        Car car2 =  context.getBean("Car2", Car.class);       
        System.out.println(car2.toString());

    }

}
