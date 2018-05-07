package dynamicpro;

import org.junit.Test;

public class CutRodProblem {
@Test
    public void test(){
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+
                cutRodRecurse(arr, size));
    System.out.println("Maximum Obtainable Value is "+
            cutRodDP(arr, size));
    }
    public int cutRodRecurse(int price[], int n)
    {
        if (n <= 0)
            return 0;
        int max_val = Integer.MIN_VALUE;

        // Recursively cut the rod in different pieces and
        // compare different configurations
        for (int i = 0; i<n; i++)
            max_val = Math.max(max_val,
                    price[i] + cutRodRecurse(price, n-i-1));
        return max_val;
    }
    /* Returns the best obtainable price for a rod of
       length n and price[] as prices of different pieces */
    public int cutRodDP(int price[],int n)
    {
        int val[] = new int[n+1];
        val[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val,
                        price[j] + val[i-j-1]);
            val[i] = max_val;
        }

        for(int i = 0; i <= n;i ++ ){
            System.out.print(val[i] + "\t");
        }
        return val[n];
    }

}
