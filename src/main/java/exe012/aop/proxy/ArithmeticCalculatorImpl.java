package exe012.aop.proxy;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    public int add(int i, int j) {
        //System.out.println("��־��Before add: " + i + "," + j);  ==> ��ͨ��AOP����ʵ��
        int result = i + j;
        //System.out.println("��־��after add: " + result);
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
