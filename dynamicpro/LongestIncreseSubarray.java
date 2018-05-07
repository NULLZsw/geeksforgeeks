package dynamicpro;
import org.junit.Test;

public class LongestIncreseSubarray {
    @Test
    public void test(){
        int[] nums = {2,1,5,3,6,4,8,9,7};
        System.out.println(getLongestIncreseSubArrar(nums));
    }
    public int getLongestIncreseSubArrar(int[] nums){
        if(nums == null  || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int length = 0;
        int max = 0;
        dp[0] = 1;
        for(int i = 1 ; i < n ; i ++){
            length = 0;
            for(int j = 0; j < i ; j ++){
                if(nums[i] > nums[j]) {
                    if(dp[j] > length) {
                        length = dp[j] ;
                    }
                }
            }
            dp[i] = length + 1;
            if(dp[i] > max){
                max = dp[i];
            }
        }
        for(int i = 0 ; i < n ; i ++){
            System.out.print(dp[i] + "\t");
        }
        return dp[n - 1];
    }

}
