package exe013.aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AspectjTest {
    
    @Test
    public void testAspectj() {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAspect.xml");
        ArithmeticCalculator2 ac = context.getBean("arithmeticCalculatorImpl2", ArithmeticCalculator2.class);
        System.out.println(ac.getClass().getName());  //ac ��ʵ�Ǵ������, �����ǽӿ� e.g.=> com.sun.proxy.$Proxy15
        ac.add(2, 5);   //�ᴥ��֪ͨ
        //ac.div(5, 0);   //�ᴥ���쳣֪ͨ
        
        
    }

}
