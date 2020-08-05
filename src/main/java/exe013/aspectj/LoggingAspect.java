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

@Component // �Ș��R��M��
@Aspect // ���R��һ������
public class LoggingAspect {

    // ǰ��֪ͨ
    // �����c���_ʽ�� �����д��ֻ��������add
    @Before(value = "execution(public int exe013.aspectj.ArithmeticCalculatorImpl2.add(int, int))")
    public void beforeMethod(JoinPoint joinPoint) {
        // ��������
        Object[] args = joinPoint.getArgs();
        // ������
        String methodName = joinPoint.getSignature().getName();
        System.out.println("ǰ��֪ͨ=> ������" + methodName + " ���� " + Arrays.toString(args));
    }

    // ����֪ͨ����Ŀ�귽��ִ��֮��ִ�У�����Ŀ�귽����û���׳��쳣, ������ִ�У� �����ܻ�ȡ�������
    // �����c���_ʽ: ��һ��*�� �������η�+����ֵ�� �ڶ���* �������࣬ ������*�� ���е��÷����� ..���е��÷����Ĳ���
    @After(value = "execution(* exe013.aspectj.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        // ������
        String methodName = joinPoint.getSignature().getName();
        System.out.println("����֪ͨ=> ������" + methodName);
    }

    // ����֪ͨ����Ŀ�귽����ȷִ��֮��ִ�У����׳��쳣, ����ִ��
    // �����c���_ʽ: returing="result" "result" �����ڷ�����������һ��
    @AfterReturning(value = "execution(* exe013.aspectj.*.*(..))", returning = "result")
    public void afterRuturningMethod(JoinPoint joinPoint, Object result) {
        // ������
        String methodName = joinPoint.getSignature().getName();
        System.out.println("����֪ͨ=> ������" + methodName + " ��� " + result.toString());
    }

    // �쳣֪ͨ����Ŀ�귽���׳��쳣��Ż�ִ��
    // �����c���_ʽ: throwing="ex" "ex" �����ڷ�����������һ��
    // ���Զ��嵱ĳ���쳣���ͷ�����֪ͨ�� e.g.NullPointException, ArithmeticException
    @AfterThrowing(value = "execution(* exe013.aspectj.*.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) { // �����Ϊ
                                                                         // NullPointException
                                                                         // ex�Ļ���
                                                                         // ��ֻ�п�ָ���쳣�Żᴥ��֪ͨ
        // ������
        String methodName = joinPoint.getSignature().getName();
        System.out.println("�쳣֪ͨ=> ������" + methodName + " �쳣 " + ex);
    }

    // ����֪ͨ��Χ����Ŀ�귽��ִ�У��������Ϊǰ�ã����ã����أ��쳣֪ͨ�Ľ����
    // �����c���_ʽ: throwing="ex" "ex" �����ڷ�����������һ��
    // ���Զ��嵱ĳ���쳣���ͷ�����֪ͨ�� e.g.NullPointException, ArithmeticException
    @Around(value = "execution(* exe013.aspectj.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {

        // ��������
        Object[] args = pjp.getArgs();
        // ������
        String methodName = pjp.getSignature().getName();

        try {
            // ����Ŀ�귽��
            // ǰ��֪ͨ
            System.out.println("����ǰ��֪ͨ=> ������" + methodName + " ���� " + Arrays.toString(args));
            Object result = pjp.proceed();
            // ����֪ͨ
            System.out.println("���Ʒ���֪ͨ=> ������" + methodName + " ��� " + result.toString());
            return result;
        }
        catch (Exception e) {
            // �쳣֪ͨ
            System.out.println("�����쳣֪ͨ=> ������" + methodName + " �쳣 " + e);
        }
        finally {
            // ����֪ͨ
            System.out.println("���ƺ���֪ͨ=> ������" + methodName);
        }
        return null;   
    }

}
