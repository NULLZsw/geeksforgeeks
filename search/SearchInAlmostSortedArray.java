package search;

import org.junit.Test;

/*
Given an array which is sorted, but after sorting some elements are moved to either
of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1].
Write an efficient function to search an element in this array.
Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 */
public class SearchInAlmostSortedArray {
    @Test
    public void test(){
        int arr[] = {3, 2, 10, 4, 40};
        int target = 4 ;
        System.out.println(binarySearch(arr,target));
        System.out.println(binarySearch(arr,0,arr.length - 1,target));
    }
    //使用递归，这样 应该比不了使用 while 循环迭代效率高，下面是 while 的版本
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l)
        {
            int mid = l + (r - l) / 2;

            // If the element is present at
            // one of the middle 3 positions
            if (arr[mid] == x)
                return mid;
            if (mid > l && arr[mid - 1] == x)
                return (mid - 1);
            if (mid < r && arr[mid + 1] == x)
                return (mid + 1);

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 2, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 2, r, x);
        }

        // We reach here when element is
        // not present in array
        return -1;
    }
    int binarySearch(int[] nums,int target){

        int lo = 0, hi = nums.length - 1;
        int mid ;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2 ;
            if(nums[mid] == target) return mid;
            else if(mid < hi && nums[mid + 1] == target) return mid + 1;
            else if(mid > lo && nums[mid - 1] == target) return mid - 1;
            else if(nums[mid] > target){
                hi = mid - 2;
            }else{
                lo = mid + 2 ;
            }
        }
        return - 1;
    }

}
