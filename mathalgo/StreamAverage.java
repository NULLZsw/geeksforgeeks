package mathalgo;

import org.junit.Test;
public class StreamAverage {
    @Test
    public void test(){
        // 10,15,20,25,30,35,40
        int[] stream = {10,20,30,40,50,60,70};
        streamAverage(stream);
    }
    public void streamAverage(int[] stream){
        int average = 0;
        for(int i = 0;i < stream.length  ; i++){
            average += (stream[i] - average) / (i+1);
            System.out.println(average);
        }
    }

}
