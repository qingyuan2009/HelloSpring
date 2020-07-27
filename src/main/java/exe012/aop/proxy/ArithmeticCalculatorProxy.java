package exe012.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/*
 * 生成代理對象
 * JDK的动态代理
 *  1. Proxy: 所有动态代理类的父类，专门用来生成代理类或者代理对象  java.lang.reflect
 *      public static Class<?> getProxyClass(ClassLoader loader, Class<?>... interfaces)
 *        -- 用于生成代理类的class对象，(加载代理类的class对象)
 *      public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 *        -- 用于生成代理对象
 *  2. InvocationHandler: 完成动态代理的整个过程
 *      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
 * 
 * 
 */

public class ArithmeticCalculatorProxy {
    // 目标对象是谁？ 如何获取代理对象？ 代理要做什么？

    // 目标对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    // 获取代理对象
    public Object getProxy() {

        // 代理对象
        Object proxy;

        /*
         * Loader: 类加载器， 加载动态生成的代理类
         * Interfaces: 多个接口， 提供目标对象的所有接口, 保证代理对象与目标对象都有相同的接口方法
         * h: InvocationHandler 对象
         */
        ClassLoader loader = target.getClass().getClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();
        
        proxy = Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {  // or use "new MyInvocationHandler()"
            //function里的内部类
            //代理对象调用代理方法，会回来调用invoke方法
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // proxy: 代理对象，一般在invoke方法中不会被使用
                // method: 正在被调用的方法对象
                // args: 正在被调用的方法对象的参数
                
                // AOP: log
                String methodName = method.getName();
                System.out.println("Logging proxy: the method is " + methodName + " begin with " + Arrays.asList(args));
                
                // 将方法的调用转到目标对象
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
