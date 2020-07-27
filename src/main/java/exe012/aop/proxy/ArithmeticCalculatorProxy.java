package exe012.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/*
 * ���ɴ��팦��
 * JDK�Ķ�̬����
 *  1. Proxy: ���ж�̬������ĸ��࣬ר���������ɴ�������ߴ������  java.lang.reflect
 *      public static Class<?> getProxyClass(ClassLoader loader, Class<?>... interfaces)
 *        -- �������ɴ������class����(���ش������class����)
 *      public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 *        -- �������ɴ������
 *  2. InvocationHandler: ��ɶ�̬�������������
 *      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
 * 
 * 
 */

public class ArithmeticCalculatorProxy {
    // Ŀ�������˭�� ��λ�ȡ������� ����Ҫ��ʲô��

    // Ŀ�����
    private ArithmeticCalculator target;

    public ArithmeticCalculatorProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    // ��ȡ�������
    public Object getProxy() {

        // �������
        Object proxy;

        /*
         * Loader: ��������� ���ض�̬���ɵĴ�����
         * Interfaces: ����ӿڣ� �ṩĿ���������нӿ�, ��֤���������Ŀ���������ͬ�Ľӿڷ���
         * h: InvocationHandler ����
         */
        ClassLoader loader = target.getClass().getClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();
        
        proxy = Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {  // or use "new MyInvocationHandler()"
            //function����ڲ���
            //���������ô����������������invoke����
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // proxy: �������һ����invoke�����в��ᱻʹ��
                // method: ���ڱ����õķ�������
                // args: ���ڱ����õķ�������Ĳ���
                
                // AOP: log
                String methodName = method.getName();
                System.out.println("Logging proxy: the method is " + methodName + " begin with " + Arrays.asList(args));
                
                // �������ĵ���ת��Ŀ�����
                Object result = method.invoke(target, args);
                
                // AOP: log 
                System.out.println("Logging proxy: the method is " + methodName + " end with " + result);
                return result;
            }

        });
        
        return proxy;
    }
    
    /*
    class MyInvocationHandler implements InvocationHandler{
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // TODO Auto-generated method stub
            return null;
        }  
    }
    */

}
