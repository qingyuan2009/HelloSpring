package exe003;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exe005.PersonList;
import exe005.PersonMap;

public class CarDemo {

    @Test
    public void testCar() {        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanCar.xml");

        // ʹ��property����Bean
        Car car =  context.getBean("Car", Car.class);       
        System.out.println(car.toString());
        
        // ʹ�ù���������Bean
        Car car2 =  context.getBean("Car2", Car.class);       
        System.out.println(car2.toString());   
        
        // ʹ�������ռ䴴��Bean
        Car car3 =  context.getBean("Car3", Car.class);       
        System.out.println(car3.toString());  
    }
    
    @Test
    public void testBeanRef() {        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanCar.xml");

        // Person Bean����Car Bean
        Person2 person =  context.getBean("person2", Person2.class);       
        System.out.println(person.toString());
            
    }
    
    @Test
    public void testInnerBean() {        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanCar.xml");

        // Person Bean�����ڲ�Car Bean
        Person2 person =  context.getBean("person3", Person2.class);       
        System.out.println(person.toString());
        
        // Bean nullֵ
        Person2 person4 =  context.getBean("person4", Person2.class);       
        System.out.println(person4.toString());
            
    }
    
    @Test
    public void testBeanList() {        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanCar.xml");
        // Bean ��ʹ����List
        PersonList personList =  context.getBean("PersonList", PersonList.class);       
        System.out.println(personList); 
        
        // Bean ��ʹ����Map
        PersonMap personMap =  context.getBean("PersonMap", PersonMap.class);       
        System.out.println(personMap);
        
        // Bean �����ü���Bean
        PersonList personList2 =  context.getBean("PersonList2", PersonList.class);       
        System.out.println(personList2); 
    }


}
