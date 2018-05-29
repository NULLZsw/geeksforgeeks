package search;

import org.junit.Test;


public class BinarySearchMostLeftTarget {
    @Test
    public void test(){
        int[] nums = {1,2,3,3,3,3,3,5,6,6,6};
        int target = 3 ;
        System.out.println(leftmosttarget(nums, target));
    }
    public int leftmosttarget(int[] nums, int target){
        int lo = 0 , hi = nums.length - 1 ;
        int mid = 0;
        //这里使用 lo 小于 hi
        while (lo < hi){
            mid = lo + (hi - lo )/ 2 ;
            if(nums[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
