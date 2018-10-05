package doitalgorithm.chpater02;

import java.util.Random;

public class P56 {

    static int maxOfQ1(int [] array){
        int max = array[0];
        for(int i = 1; i< array.length; i++){
            if(max < array[i])
                max = array[i];
        }

        return max;
    }

    static int[] initArray(){
        Random random = new Random();
        int n = random.nextInt();
        int [] array = new int[n];
        for(int i = 0; i < array.length; i++){
            array[i] = 100+ random.nextInt();
        }

        return array;
    }
}
