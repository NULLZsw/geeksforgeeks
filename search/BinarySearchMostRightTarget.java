package search;

import org.junit.Test;

public class BinarySearchMostRightTarget {
    @Test
    public void test(){
        int[] nums = {1,2,3,3,3,3,3,5,6,6,6};
        int target = 3 ;
        System.out.println(rightmosttarget(nums, target));
    }
    public int rightmosttarget(int[] nums, int target){
        int lo = 0 , hi = nums.length - 1 ;
        int mid = 0;
        //这里使用 lo 小于 hi
        while (lo < hi){
            mid = lo + (hi - lo ) / 2 + 1 ; // Make mid biased to the right
            if(nums[mid] <= target) lo = mid ;
            else hi = mid - 1;
        }
        return hi;
    }
}
