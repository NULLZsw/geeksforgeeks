package mathalgo;

import org.junit.Test;

public class DivisibilityBy7 {
    @Test
    public void test(){
        System.out.println(divisibilityBy7(616));
    }
    public boolean divisibilityBy7(int n){
        if(n < 0) return divisibilityBy7(- n);
        if(n == 0 || n == 7) return true;
        if(n < 10) return false;
        return divisibilityBy7(n / 10 - 2 * (n - n / 10 * 10));
    }

}
