package dynamicpro;

import org.junit.Test;

public class UglyNumber {
@Test
    public void test(){

    System.out.println("150th ugly no. is "+ getNthUglyNo(150));
    System.out.println("150th ugly no. is "+ getNthUglyNumberDP(150));
    }
    /*This function divides a by greatest divisible
    power of b*/
    public int maxDivide(int a, int b)
    {
        while(a % b == 0)
            a = a/b;
        return a;
    }

    /* Function to check if a number is ugly or not */
    public int isUgly(int no)
    {
        no = maxDivide(no, 2);
        no = maxDivide(no, 3);
        no = maxDivide(no, 5);

        return (no == 1)? 1 : 0;
    }

    /* Function to get the nth ugly number*/
    public int getNthUglyNo(int n)
    {
        int i = 1;
        int count = 1; // ugly number count

        // check for all integers until count becomes n */
        while(n > count)
        {
            i++;
            if(isUgly(i) == 1)
                count++;
        }
        return i;
    }
    public int getNthUglyNumberDP(int n){
        int[] dp = new int[n];
        dp[0] = 1 ;
        int i2 = 0,i3 = 0,i5 = 0;
        int next_multiple_of_2 = dp[i2] * 2,next_multiple_of_3 = dp[i3] * 3,next_multiple_of_5 = dp[i5] * 5;
        int nextminnum;
        for(int i = 1 ; i < n ; i ++){
            nextminnum = minNumber(next_multiple_of_2,next_multiple_of_3,next_multiple_of_5);
            dp[i] = nextminnum;
            if(nextminnum == next_multiple_of_2){
                i2 ++;
                next_multiple_of_2 = dp[i2] * 2 ;
            }
            if(nextminnum == next_multiple_of_3){
                i3 ++;
                next_multiple_of_3 = dp[i3] * 3 ;
            }
            if(nextminnum == next_multiple_of_5){
                i5 ++;
                next_multiple_of_5 = dp[i5] * 5 ;
            }
        }
        return dp[n-1];
    }
    public int minNumber(int num1,int num2,int num3){
        return Math.min(num1,Math.min(num2,num3));
    }
}
