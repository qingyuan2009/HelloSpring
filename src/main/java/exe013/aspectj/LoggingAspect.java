package exe013.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component  //�Ș��R��M��
@Aspect     //���R��һ������
public class LoggingAspect {
    
    //ǰ��֪ͨ
    //�����c���_ʽ
    @Before(value="execution(public int exe013.aspectj.ArithmeticCalculatorImpl2.add(int, int))")
    public void beforeMethod() {
        System.out.println("ǰ��֪ͨ=>" + "xyz");
        
    }

}
