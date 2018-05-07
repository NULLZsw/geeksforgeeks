package dynamicpro;

import org.junit.Test;

public class LargestSumContiguous {
@Test
    public void test(){
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(a));
    }
    public int maxSubArraySum(int nums[]){
        if(nums == null || nums.length == 0) return 0 ;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1 ; i < n ;i ++ ){
            if(dp[i-1] < 0 ){
                dp[i] = nums[i];
            }
            else{
                dp[i] = dp[i-1] + nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n ;i ++){
            System.out.print(dp[i] + "\t");
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}
