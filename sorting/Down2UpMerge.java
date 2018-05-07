package sorting;
//这个地方还是借助额外数组比较好
 // 4，5，6，7，1，2，3，8
//使用两个指针分别指向前后两段有序数组进行排序没有那么简单
public class Down2UpMerge {

    private static int[] aux;  //归并所需的辅助数组
    public static void sort(int[] a){
        //进行lgN次来两两归并
        int N = a.length;
        aux = new int[N];
        for (int sz = 1; sz < N; sz = sz + sz) {  //sz：子数组的大小, sz成2的幂次方增长
            for(int lo = 0; lo < N-sz; lo += sz+sz){//lo:子数组的索引，  sz=1时，子数组有2个数，sz=2时，子数组有4个数，sz=4时，子数组有8个数
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    public static void merge(int[] a, int lo, int mid, int hi){
        // 将a[lo...mid] 和a[mid+1...hi]归并
        int i = lo; // 第一个有序区域的索引
        int j = mid + 1; // 第二个有序区域的索引

        for (int k = lo; k <= hi; k++) {// 将a[lo...hi]复制到aux[lo...hi]中，这样在操作a[]是数据不会被覆盖而丢
            // aux[] 是在类中建立的一个辅助数组，它的大小和a[]的大小一样大
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) { // 归并到a[lo...hi]中
            if (i > mid) { // 左半边用尽，也就是当第一个有序数组的所有数据都放入到归并的数组中了，由于上一次结果会i++，
                // 所以会进入到这个条件中，那就直接把右边的往归并数组里扔就可以了
                a[k] = aux[j++];
            } else if (j > hi) { // 同上，当右半边数据（第二个有序区域）都放入到归并的数组中了，那就直接吧剩下的左边数据（第一个有序数组）放入归并数组
                a[k] = aux[i++];
            } else if (aux[j]<aux[i]) {// 这句话才是归并在比较大小的那句，谁小谁放入数组中
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

}
