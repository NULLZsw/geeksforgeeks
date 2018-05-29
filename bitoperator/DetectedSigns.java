package bitoperator;

import org.junit.Test;

public class DetectedSigns {
    @Test
    public void test(){
        int num1 = 10;
        int num2 = -100;
        System.out.println(detectedsign(num1,num2));
    }
    public int detectedsign(int num1,int num2){
        if((num1 ^ num2) < 0) return -1 ;
         return + 1;
    }
}
