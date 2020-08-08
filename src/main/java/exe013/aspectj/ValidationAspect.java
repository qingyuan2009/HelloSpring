package exe013.aspectj;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component // 先標識為組件
@Aspect // 標識為一個切面
@Order(1)  //切面的优先级，不写int的话默认优先级最后
public class ValidationAspect {
    
    //统一定义切入点表达式
    @Pointcut( "execution(* exe013.aspectj.*.*(..))")
    public void declarePointcut() {}
    
    //@Before(value = "execution(* exe013.aspectj.*.*(..))")
    @Before("declarePointcut()")  //使用切入点表达式
    public void beforeMethod(JoinPoint joinPoint) {
        // 方法参数
        Object[] args = joinPoint.getArgs();
        // 方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Validation前置通知=> 方法名" + methodName + " 参数 " + Arrays.toString(args));
    }

}
