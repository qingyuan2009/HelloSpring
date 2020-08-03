package exe013.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component  //先標識為組件
@Aspect     //標識為一個切面
public class LoggingAspect {
    
    //前置通知
    //切入點表達式
    @Before(value="execution(public int exe013.aspectj.ArithmeticCalculatorImpl2.add(int, int))")
    public void beforeMethod() {
        System.out.println("前置通知=>" + "xyz");
        
    }

}
