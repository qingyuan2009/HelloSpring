package exe012.aop.proxy;

import java.util.Properties;

public class ProxyTest {
    
    public static void main(String[] args) throws Exception {
        
        //動態代理類都是動態生成的， 默認是在memory中， 這裏可以把它保存到硬盤
        //可以com文件夾中看到生成的代理類： $Proxy0.class         
        Properties properties = System.getProperties();
        properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        
        
        //目标对象
        ArithmeticCalculator target = new ArithmeticCalculatorImpl(); 
        
        //创建代理对象  方式1: newProxyInstance
        Object obj = new InstanceProxy(target).getProxy();  
        ArithmeticCalculator proxy = (ArithmeticCalculator) obj;  //强转       
        System.out.println(proxy.getClass().getName());        
        int result = proxy.add(1, 1);
        System.out.println("result is " + result);
        
        /*
         * Logging proxy: the method is add begin with [1, 1]
         * Logging proxy: the method is add end with 2
         * result is 2
         */
        
        
        //创建代理对象 方式2: getProxyClass
        Object obj2 = new ClassProxy(target).getProxy();
        ArithmeticCalculator proxy2 = (ArithmeticCalculator) obj2; 
        int result2 = proxy2.add(1, 1);
        System.out.println("result is " + result2);
        
    }

}
