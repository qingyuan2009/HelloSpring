package exe013.aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AspectjTest {
    
    @Test
    public void testAspectj() {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAspect.xml");
        ArithmeticCalculator2 ac = context.getBean("arithmeticCalculatorImpl2", ArithmeticCalculator2.class);
        System.out.println(ac.getClass().getName());  //ac 其实是代理对象, 必须是接口 e.g.=> com.sun.proxy.$Proxy15
        ac.add(2, 5);   //会触发通知
        //ac.div(5, 0);   //会触发异常通知
        
        
    }

}
