package BeanRelation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanRelationDemo {
    
    @Test
    public void testFactoryBean() {        
        
        ApplicationContext context = new ClassPathXmlApplicationContext("BeanRelation.xml");
        
        // Bean的继承关系
        Address addr1 =  context.getBean("Address1", Address.class);       
        System.out.println(addr1.toString());
        Address addr2 =  context.getBean("Address2", Address.class);       
        System.out.println(addr2.toString());
        
        // 抽象Bean
        Address addr4 =  context.getBean("Address4", Address.class);       
        System.out.println(addr4.toString());
        
        // Bean的依赖关系
        Address addr5 =  context.getBean("Address5", Address.class);       
        System.out.println(addr5.toString());
    }

}
