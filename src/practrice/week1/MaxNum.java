package src.practrice.week1;

import java.util.ArrayList;
import java.util.List;

public class MaxNum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(99);
        list.add(12);
        list.add(8);
        list.add(45);
        list.add(498);
        list.add(444);
        list.add(11);

        int result = solve(list);
        System.out.println(list.get(result)+ " / " + result);
    }

    public static int solve(List<Integer> inputArray){
        int result_index = 0;
        int result_maxNum = inputArray.get(0);
        for (int i = 1; i < inputArray.size(); i++){
            if(result_maxNum <= inputArray.get(i)){
                result_maxNum = inputArray.get(i);
                result_index = i;
            }
        }

        return result_index;
    }
}
