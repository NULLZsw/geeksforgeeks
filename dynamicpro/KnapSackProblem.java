package dynamicpro;

import org.junit.Test;

public class KnapSackProblem {
@Test
    public void test(){
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSackRecurse(W, wt, val, n));
        System.out.println(knapSackDP(W, wt, val, n));
    System.out.println(knapSackopt(W,wt,val,n));
    System.out.println(knapSackcomplete(W,wt,val,n));
    }
    public int max(int a, int b) { return (a > b)? a : b; }

    // Returns the maximum value that can be put in a knapsack of capacity W
    public int knapSackRecurse(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n-1] > W)
            return knapSackRecurse(W, wt, val, n-1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else return max( val[n-1] + knapSackRecurse(W-wt[n-1], wt, val, n-1),
                knapSackRecurse(W, wt, val, n-1)
        );
    }
    //这里 解决的是 0-1 背包问题，内存可以进行优化
    public int knapSackDP(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i==0 || w==0)
                    K[i][w] = 0;
                    //  当 背包可以放下 当前物品的时候
                else if (wt[i-1] <= w)
                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else    //当前背包放不下
                    K[i][w] = K[i-1][w];
            }
        }
        return K[n][W];
    }
    public int knapSackopt(int W, int weight[], int val[], int n) {
        int dp[] = new int[W + 1];
        // Build table K[][] in bottom up manner
        for (int i = 1; i <= n; i++) {
            int w = weight[i - 1], v = val[i - 1];
            for (int j = W; j >= 1; j --) {
                if(j >= w)
                dp[j] = max(v + dp[j - w],  dp[j]);
            }
        }
        return dp[W];
    }
    //完全背包
    public int knapSackcomplete(int W, int weight[], int val[], int n) {
        int dp[] = new int[W + 1];
        // Build table K[][] in bottom up manner
        for (int i = 1; i <= n; i++) {
            int w = weight[i - 1], v = val[i - 1];
            //这里 跟 0-1 背包区别就在这个内层递归的顺序
            for (int j = 1; j <= W; j ++) {
                if(j >= w)
                    dp[j] = max(v + dp[j - w],  dp[j]);
            }
        }
        return dp[W];
    }
    //完全背包另一种写法，是将两个 for 循环颠倒了

}
