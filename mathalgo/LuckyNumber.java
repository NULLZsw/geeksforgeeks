package mathalgo;

import org.junit.Test;

/*
Lucky numbers are subset of integers. Rather than going into much theory, let us see the process of arriving at lucky numbers,

Take the set of integers
1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,……

First, delete every second number, we get following reduced set.
1,3,5,7,9,11,13,15,17,19,…………

Now, delete every third number, we get
1, 3, 7, 9, 13, 15, 19,….….

Continue this process indefinitely……
Any number that does NOT get deleted due to above process is called “lucky”.

Therefore, set of lucky numbers is 1, 3, 7, 13,………
 */
public class LuckyNumber {
@Test
    public void test(){
        int x = 5;
        if( isLucky(x) )
            System.out.println(x+" is a lucky no.");
        else
            System.out.println(x+" is not a lucky no.");
    }
    static int counter =2;
    public boolean isLucky(int n)
    {
        // variable next_position is just for readability of
        // the program we can remove it and use n only
        int next_position = n;
        if(counter > n)
            return true;
        if(n%counter == 0)
            return false;

        // calculate next position of input no
        next_position -= next_position/counter;

        counter++;
        return isLucky(next_position);
    }


}
