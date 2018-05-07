package search;

import org.junit.Test;

public class FindCommonEleAmongThreeArray {

    //最容易想到的解决方案是 ，将其中两个数组的共有部分临时保存，然后和第三个数组比较
    //将最终的共有元素保存就是答案
    @Test
    public void test(){
        int[] arr1 = {1, 5, 10, 20, 40, 80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};
        findCommonElement(arr1,arr2,arr3);
    }
    //这里采用三个指针移动的方案
    public void findCommonElement(int[] arr1,int[] arr2, int[] arr3){
        int i = 0, j = 0 , k = 0;
        while(i < arr1.length && j < arr2.length && k < arr3.length){
            //当 三个数 一样的时候 ，输出该数字，并将三个下标 各增加1
            if( arr1[i] == arr2[j]  && arr2[j] == arr3[k]){
                System.out.println(arr1[i]);
                 i ++ ;
                 j ++ ;
                 k ++ ;
            }
            //当第一个数小于第二个，  较小的数字已经不可能 成为共有元素了 ，第一个下标右移
            else if(arr1[i] < arr2[j]) {i ++;}
            //第一个 数 大于等于 第二个数 ，如果第二个 数又小于第三个  ，这时，中间的数字是最小的，排除可能，右移
            else if(arr2[j] < arr3[k]) {j ++;}
            //第三个数是 最小的，排除可能，下标右移
            else{ k ++ ;}
        }

    }

}
