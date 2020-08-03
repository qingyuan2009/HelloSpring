package exe013.aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AspectjTest {
    
    @Test
    public void testAspectj() {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAspect.xml");
        ArithmeticCalculator2 ac = context.getBean("arithmeticCalculatorImpl2", ArithmeticCalculator2.class);
        ac.add(2, 5);
        
        
        
    }

}
