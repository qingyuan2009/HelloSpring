package exe012.aop.proxy;

import java.lang.reflect.Constructor;
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

public class ClassProxy {
    // 目标对象是谁？ 如何获取代理对象？ 代理要做什么？

    // 目标对象
    // private ArithmeticCalculator target;
    private Object target; // 更高級，可以對任何類進行代理

    public ClassProxy(Object target) {
        this.target = target;
    }

    // 获取代理对象
    public Object getProxy() throws Exception {

        // 代理对象
        Object proxy;

        ClassLoader loader = target.getClass().getClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();

        Class proxyClass = Proxy.getProxyClass(loader, interfaces);

        Constructor con = proxyClass.getDeclaredConstructor(InvocationHandler.class);

        proxy = con.newInstance(new InvocationHandler() {

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
   
}
