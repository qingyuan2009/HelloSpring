package exe012.aop.proxy;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    public int add(int i, int j) {
        //System.out.println("日志：Before add: " + i + "," + j);  ==> 将通过AOP代理实现
        int result = i + j;
        //System.out.println("日志：after add: " + result);
        return result;
    }

    public int sub(int i, int j) {       
        int result = i - j;       
        return result;
    }

    public int mul(int i, int j) {        
        int result = i * j;        
        return result;
    }

    public int div(int i, int j) {       
        int result = i / j;       
        return result;
    }

}
