package exe001.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exe001.spring.helloworld.HelloWorld;
import exe001.spring.helloworld.HelloWorldService;

public class HelloProgram {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
        HelloWorld hw = service.getHelloWorld();
        hw.sayHello();
    }
}
