package exe004;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookDemo {
    
    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanCar.xml");
        Book book =  context.getBean("book", Book.class);       
        System.out.println(book.toString());
    }

}
