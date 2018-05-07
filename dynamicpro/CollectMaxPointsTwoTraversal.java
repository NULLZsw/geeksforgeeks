package dynamicpro;

import org.junit.Test;

public class CollectMaxPointsTwoTraversal {

    @Test
    public void test(){
        int[][] arr = {{3, 6, 8, 2},
            {5, 2, 4, 3},
            {1, 1, 20, 10},
            {1, 1, 20, 10},
            {1, 1, 20, 10},
        };
        System.out.println(geMaxCollection(arr));
    }
    // checks whether a given input is valid or not
    public boolean isValid(int x, int y1, int y2)
    {
        return (x >= 0 && x < 5 && y1 >=0 &&
                y1 < 4 && y2 >=0 && y2 < 4);
    }

    // Driver function to collect max value
    public int getMaxUtil(int[][] arr, int[][][] mem, int x, int y1, int y2)
    {
    /*---------- BASE CASES -----------*/
        // if P1 or P2 is at an invalid cell
        if (!isValid(x, y1, y2)) return Integer.MIN_VALUE;

        // if both traversals reach their destinations
        if (x == 5-1 && y1 == 0 && y2 == 4-1)
            return (y1 == y2)? arr[x][y1]: arr[x][y1] + arr[x][y2];

        // If both traversals are at last row but not at their destination
        if (x == 5-1) return Integer.MIN_VALUE;

        // If subproblem is already solved
        if (mem[x][y1][y2] != -1) return mem[x][y1][y2];

        // Initialize answer for this subproblem
        int ans = Integer.MIN_VALUE;

        // this variable is used to store gain of current cell(s)
        int temp = (y1 == y2)? arr[x][y1]: arr[x][y1] + arr[x][y2];

    /* Recur for all possible cases, then store and return the
       one with max value */
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1, y2-1));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1, y2+1));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1, y2));

        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1-1, y2));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1-1, y2-1));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1-1, y2+1));

        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1+1, y2));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1+1, y2-1));
        ans = Math.max(ans, temp + getMaxUtil(arr, mem, x+1, y1+1, y2+1));

        return (mem[x][y1][y2] = ans);
    }

    // This is mainly a wrapper over recursive function getMaxUtil().
// This function creates a table for memoization and calls
// getMaxUtil()
    public int geMaxCollection(int arr[][])
    {
        // Create a memoization table and initialize all entries as -1
        int[][][] mem = new int[5][4][4];
        for(int i = 0;i < 5;i ++){
            for(int j = 0;j < 4 ;j ++){
                for(int k = 0; k < 4; k ++){
                    mem[i][j][k] = -1;
                }
            }
        }

        // Calculation maximum value using memoization based function
        // getMaxUtil()
        return getMaxUtil(arr, mem, 0, 0, 3);
    }

}
