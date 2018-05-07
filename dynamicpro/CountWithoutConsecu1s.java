package dynamicpro;

import org.junit.Test;

public class CountWithoutConsecu1s {
    @Test
    public void test(){
        //这个好像是斐波那契数列
        System.out.println(countStrings(3));
        System.out.println(countStrings(4));
        System.out.println(countStrings(5));
        System.out.println(countStrings(6));
        System.out.println(countStrings(7));
        System.out.println(countStrings(8));
    }
    public int countStrings(int n){
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = 1;
        b[0] = 1;
        for(int i = 1 ; i < n ;i ++){
            b[i] = a[i-1];
            a[i] = b[i-1]+a[i-1];
        }
    return a[n-1] + b[n -1];
    }
}
