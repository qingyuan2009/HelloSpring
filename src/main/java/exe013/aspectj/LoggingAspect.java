package exe013.aspectj;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component // 先標識為組件
@Aspect // 標識為一個切面
public class LoggingAspect {

    // 前置通知
    // 切入點表達式： 这里的写法只能作用于add
    @Before(value = "execution(public int exe013.aspectj.ArithmeticCalculatorImpl2.add(int, int))")
    public void beforeMethod(JoinPoint joinPoint) {
        // 方法参数
        Object[] args = joinPoint.getArgs();
        // 方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("前置通知=> 方法名" + methodName + " 参数 " + Arrays.toString(args));
    }

    // 后置通知：在目标方法执行之后执行，不管目标方法有没有抛出异常, 都可以执行， 但不能获取方法结果
    // 切入點表達式: 第一个*： 任意修饰符+返回值， 第二个* ：所有类， 第三个*： 所有调用方法， ..所有调用方法的参数
    @After(value = "execution(* exe013.aspectj.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        // 方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("后置通知=> 方法名" + methodName);
    }

    // 返回通知：在目标方法正确执行之后执行，如抛出异常, 则不能执行
    // 切入點表達式: returing="result" "result" 必须于方法参数保持一致
    @AfterReturning(value = "execution(* exe013.aspectj.*.*(..))", returning = "result")
    public void afterRuturningMethod(JoinPoint joinPoint, Object result) {
        // 方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("返回通知=> 方法名" + methodName + " 结果 " + result.toString());
    }

    // 异常通知：在目标方法抛出异常后才会执行
    // 切入點表達式: throwing="ex" "ex" 必须于方法参数保持一致
    // 可以定义当某种异常类型发生才通知， e.g.NullPointException, ArithmeticException
    @AfterThrowing(value = "execution(* exe013.aspectj.*.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) { // 如果改为
                                                                         // NullPointException
                                                                         // ex的话，
                                                                         // 当只有空指针异常才会触发通知
        // 方法名
        String methodName = joinPoint.getSignature().getName();
        System.out.println("异常通知=> 方法名" + methodName + " 异常 " + ex);
    }

    // 环绕通知：围绕着目标方法执行，可以理解为前置，后置，返回，异常通知的结合体
    // 切入點表達式: throwing="ex" "ex" 必须于方法参数保持一致
    // 可以定义当某种异常类型发生才通知， e.g.NullPointException, ArithmeticException
    @Around(value = "execution(* exe013.aspectj.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {

        // 方法参数
        Object[] args = pjp.getArgs();
        // 方法名
        String methodName = pjp.getSignature().getName();

        try {
            // 调用目标方法
            // 前置通知
            System.out.println("环绕前置通知=> 方法名" + methodName + " 参数 " + Arrays.toString(args));
            Object result = pjp.proceed();
            // 返回通知
            System.out.println("环绕返回通知=> 方法名" + methodName + " 结果 " + result.toString());
            return result;
        }
        catch (Exception e) {
            // 异常通知
            System.out.println("环绕异常通知=> 方法名" + methodName + " 异常 " + e);
        }
        finally {
            // 后置通知
            System.out.println("环绕后置通知=> 方法名" + methodName);
        }
        return null;   
    }

}
