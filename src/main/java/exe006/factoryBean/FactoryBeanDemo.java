package exe006.factoryBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exe003.Car;


public class FactoryBeanDemo {
    
    @Test
    public void testFactoryBean() {        
        
        ApplicationContext context = new ClassPathXmlApplicationContext("factoryBean.xml");
        //  π”√factory Bean
        Car car =  context.getBean("Car", Car.class);       
        System.out.println(car.toString());
        
    }
    

}
