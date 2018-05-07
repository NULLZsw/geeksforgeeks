package sorting;

import org.junit.Test;

public class IterativeMergeSortArrays {
    @Test
    public void test(){
        int arr[] = {12, 11, 13, 5, 6, 7};
        mergeSort(arr);
        for(int i = 0; i < arr.length ; i ++){
            System.out.print(arr[i] + "   ");
        }

    }
    //这是一个 自上而下的 归并排序 ，没有将算法拆开成三个步骤，（1.切分找到中点，2.递归切分成的两个部分 3.将两个数组归并）
    public  void mergeSort(int[] array)
    {
        if(array == null)
        {
            return;
        }
        //1. 切分数组 ，将原数组尽可能切分为 尽可能相等的两个 子数组
        if(array.length > 1)
        {
            int mid = array.length / 2;

            // Split left part
            int[] left = new int[mid];
            for(int i = 0; i < mid; i++)
            {
                left[i] = array[i];
            }

            // Split right part
            int[] right = new int[array.length - mid];
            for(int i = mid; i < array.length; i++)
            {
                right[i - mid] = array[i];
            }
            // 将切分出的数组，递归切分子数组
            mergeSort(left);
            mergeSort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays
            while(i < left.length && j < right.length)
            {
                if(left[i] < right[j])
                {
                    array[k] = left[i];
                    i++;
                }
                else
                {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }
            // Collect remaining elements
            while(i < left.length)
            {
                array[k] = left[i];
                i++;
                k++;
            }
            while(j < right.length)
            {
                array[k] = right[j];
                j++;
                k++;
            }
        }
    }

}
