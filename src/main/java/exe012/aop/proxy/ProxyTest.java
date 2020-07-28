package exe012.aop.proxy;

import java.util.Properties;

public class ProxyTest {
    
    public static void main(String[] args) throws Exception {
        
        //�ӑB������ǄӑB���ɵģ� Ĭ�J����memory�У� �@�Y���԰������浽Ӳ�P
        //����com�ļ��A�п������ɵĴ���� $Proxy0.class         
        Properties properties = System.getProperties();
        properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        
        
        //Ŀ�����
        ArithmeticCalculator target = new ArithmeticCalculatorImpl(); 
        
        //�����������  ��ʽ1: newProxyInstance
        Object obj = new InstanceProxy(target).getProxy();  
        ArithmeticCalculator proxy = (ArithmeticCalculator) obj;  //ǿת       
        System.out.println(proxy.getClass().getName());        
        int result = proxy.add(1, 1);
        System.out.println("result is " + result);
        
        /*
         * Logging proxy: the method is add begin with [1, 1]
         * Logging proxy: the method is add end with 2
         * result is 2
         */
        
        
        //����������� ��ʽ2: getProxyClass
        Object obj2 = new ClassProxy(target).getProxy();
        ArithmeticCalculator proxy2 = (ArithmeticCalculator) obj2; 
        int result2 = proxy2.add(1, 1);
        System.out.println("result is " + result2);
        
    }

}
