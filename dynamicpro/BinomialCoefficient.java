package dynamicpro;

import org.junit.Test;

public class BinomialCoefficient {
@Test
    public void test(){
        int n = 5, k = 2;
        System.out.println("Value of C("+n+","+k+") is "+binomialCoeffRecurse(n, k));
        System.out.println("Value of C("+n+","+k+") is "+binomialCoeffDP(n, k));
    }
    //  C(n,k) = C(n-1,k-1) + C(n-1,k)
    public int binomialCoeffRecurse(int n, int k)
    {

        // Base Cases
        if (k == 0 || k == n)
            return 1;

        // Recur
        return binomialCoeffRecurse(n - 1, k - 1) +
                binomialCoeffRecurse(n - 1, k);
    }
    public int binomialCoeffDP(int n, int k)
    {
        int C[][] = new int[n+1][k+1];
        int i, j;

        // Calculate  value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= min(i, k); j++) {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;
                    // Calculate value using previosly stored values
                else
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }
        return C[n][k];
    }
    public int min(int a, int b)
    {
        return (a<b)? a: b;
    }
}
