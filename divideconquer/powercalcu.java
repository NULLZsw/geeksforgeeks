package divideconquer;

import org.junit.Test;

public class powercalcu {
    @Test
    public void test(){
        System.out.println(mypower(5,-3));
    }
    //第一种写法
    public int power(int base, int exponent){
        if (exponent == 0)
            return 1;
        else if (exponent % 2 == 0)
            return power(base, exponent / 2) * power(base, exponent / 2);
        else
            return base * power(base, exponent / 2) * power(base, exponent / 2);
    }
    //第二种写法
    public double mypower(double base, int exponent){
        if(exponent == 0) return 1;
        if(exponent < 0){
            base = 1 / base;
            exponent = -exponent;
        }
        if(exponent % 2 == 0) return mypower(base * base , exponent / 2);
        else  return base * mypower(base * base , exponent / 2);
    }
}
