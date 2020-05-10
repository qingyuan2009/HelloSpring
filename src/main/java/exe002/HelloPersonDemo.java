package exe002;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloPersonDemo {

    public static void main(String[] args) {
        //����IOC����
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        
        //ͨ��Bean ID ��ȡBean����
        Person person = (Person) context.getBean("Person");  
        
        //Ҳ����ʹ��class,����cast,��Ҫ��xml���ò�����������ͬ��class
        //Person person = context.getBean(Person.class);
        
        //���xml������������ͬ��class
        //Person person = context.getBean("Person2", Person.class);
        
        person.SayHello();
    }

}
