package mathalgo;

import org.junit.Test;

public class EfficientExponential {
   @Test
    public void test(){
        System.out.println(efficientExponential(10,1));
    }
    //Taylor
    //e^x = 1 + x + x/2 + x^2/6 + x^3/24 + ...
    //e^x = 1 + x(1 + x/2(1 + x/3(1 + x/4) ...)...)
    public float efficientExponential(int n ,float x){
        float sum = 1 ;
        for(int i = n-1 ; i > 0 ; i --){
            sum = 1 + x * sum/i;
        }
        return sum;
    }

}
