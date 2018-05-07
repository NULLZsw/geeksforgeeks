package dynamicpro;

import org.junit.Test;

public class MaxSumIncreSequence {
@Test
    public void test(){
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum increasing "+
                " subsequence is "+
                maxSumIS( arr, n ) );
        System.out.println("Sum of maximum sum increasing "+
            " subsequence is "+
            maxSumIS2( arr, n ) );
    }
    public int maxSumIS( int arr[], int n )
    {
        int i, j, max = 0;
        int msis[] = new int[n];

        /* Initialize msis values for all indexes */
        for ( i = 0; i < n; i++ )
            msis[i] = arr[i];

        /* Compute maximum sum values in bottom up manner */
        //这是我写的逻辑，数组中的结果与 答案上面一样 ，处理的次数应该也是一样的
        for ( i = 0; i < n; i++ )
            for ( j = i; j < n; j++ )
                if ( arr[j] > arr[i] &&
                        msis[j] < msis[i] + arr[j])
                    msis[j] = msis[i] + arr[j];

        /* Pick maximum of all msis values */
        for ( i = 0; i < n; i++ )
            if ( max < msis[i] )
                max = msis[i];
        for(i = 0 ; i < msis.length ; i ++){
            System.out.print(msis[i] + "\t");
        }
        System.out.println();

        return max;
    }
    public int maxSumIS2( int arr[], int n )
    {
        int i, j, max = 0;
        int msis[] = new int[n];

        /* Initialize msis values for all indexes */
        for ( i = 0; i < n; i++ )
            msis[i] = arr[i];

        /* Compute maximum sum values in bottom up manner */
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr[i] > arr[j] &&
                        msis[i] < msis[j] + arr[i])
                    msis[i] = msis[j] + arr[i];

        /* Pick maximum of all msis values */
        for ( i = 0; i < n; i++ )
            if ( max < msis[i] )
                max = msis[i];

        for(i = 0 ; i < msis.length ; i ++){
            System.out.print(msis[i] + "\t");
        }

        return max;
    }
}
