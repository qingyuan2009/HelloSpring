package exe013.aspectj;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component // �Ș��R��M��
@Aspect // ���R��һ������
@Order(1)  //��������ȼ�����дint�Ļ�Ĭ�����ȼ����
public class ValidationAspect {
    
    //ͳһ�����������ʽ
    @Pointcut( "execution(* exe013.aspectj.*.*(..))")
    public void declarePointcut() {}
    
    //@Before(value = "execution(* exe013.aspectj.*.*(..))")
    @Before("declarePointcut()")  //ʹ���������ʽ
    public void beforeMethod(JoinPoint joinPoint) {
        // ��������
        Object[] args = joinPoint.getArgs();
        // ������
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Validationǰ��֪ͨ=> ������" + methodName + " ���� " + Arrays.toString(args));
    }

}
