package mathalgo;

import org.junit.Test;

public class MagicSquare {
    @Test
    public void test(){
        generateSquare(7);
    }
    public void generateSquare(int n){
        int[][] magicSquare = new int[n][n];
        int i = n / 2 ;
        int j = n - 1 ;
        for(int num = 1;num <= n * n;){
            if(i == -1 && j == n){
                j = n - 2 ;
                i = 0;
            }
            else {
                if( j == n )
                    j = 0;
                if(i < 0)
                    i = n - 1;
            }
            if(magicSquare[i][j] != 0){
                j -= 2;
                i ++;
                continue;
            }else{
                magicSquare[i][j] = num ++;
            }
            j ++;
            i --;
        }
        System.out.println(" The Magic Square for " + n + ":");
        for(i = 0 ; i < n ; i ++){
            for(j = 0 ; j < n; j ++){
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }

    }
}
