package exe012.aop.proxy;

public class ProxyTest {
    
    public static void main(String[] args) {
        
        //目标对象
        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        
        //创建代理对象
        Object obj = new ArithmeticCalculatorProxy(target).getProxy();
        
        //强转
        ArithmeticCalculator proxy = (ArithmeticCalculator) obj;
        
        int result = proxy.add(1, 1);
        System.out.println("result is " + result);
        
        /*
         * Logging proxy: the method is add begin with [1, 1]
         * Logging proxy: the method is add end with 2
         * result is 2
         */
        
    }

}
