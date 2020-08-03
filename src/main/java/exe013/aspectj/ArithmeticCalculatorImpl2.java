package exe013.aspectj;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculatorImpl2")
public class ArithmeticCalculatorImpl2 implements ArithmeticCalculator2 {

    public int add(int i, int j) {        
        int result = i + j;       
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
