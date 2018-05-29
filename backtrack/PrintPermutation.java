package backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintPermutation {
    @Test
    public void test(){
        List<List<Integer>> res = Permutation();
        System.out.println(res);
    }
    // 输出所有 四个数字 的和为 target 的四个数字组合
    @Test
    public void test2(){
        int[] nums = {1,2,3,4,5,6,7};
        int target = 15;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helperTarget(res,curr,nums,0,target,0);
        System.out.println(res);
    }
    public List<List<Integer>> Permutation(){
        int[] nums = {1,2,3,4,5,6,7};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(res,curr,nums,0);
        return res ;
    }
    public void helper(List<List<Integer>> res,List<Integer> curr,int[] nums,int level){
        if(level == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[level]);
        helper(res,curr,nums,level + 1);
        curr.remove(curr.size() - 1);
        helper(res,curr,nums,level + 1);
    }
    public void helperTarget(List<List<Integer>> res,List<Integer> curr,int[] nums,int level,int sum,int size){
        if(sum == 0 && size == 4){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(size > 4 || level == nums.length) return;
        curr.add(nums[level]);
        helperTarget(res,curr,nums,level + 1,sum - nums[level],size + 1);
        curr.remove(curr.size() - 1);
        helperTarget(res,curr,nums,level + 1 ,sum ,size);
    }
}
