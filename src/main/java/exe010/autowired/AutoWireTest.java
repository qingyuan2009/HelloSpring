package exe010.autowired;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireTest {

    @Test
    public void testAutoWire() {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAutoWired.xml");
        //Person 是使用自动装配
        
        //autowire byType
        Person3 person = context.getBean("Person", Person3.class);
        System.out.println(person.toString());
        
        //autowire byName
        Person3 person2 = context.getBean("Person2", Person3.class);
        System.out.println(person2.toString());

    }

}
