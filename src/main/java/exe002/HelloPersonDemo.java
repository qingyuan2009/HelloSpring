package exe002;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloPersonDemo {

    public static void main(String[] args) {
        //创建IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        //通过Bean ID 获取Bean对象
        Person person = (Person) context.getBean("Person");  
        
        //也可以使用class,无需cast,但要求xml配置不能有两个相同的class
        //Person person = context.getBean(Person.class);
        
        //如果xml配置有两个相同的class
        //Person person = context.getBean("Person2", Person.class);
        
        person.SayHello();
    }

}
