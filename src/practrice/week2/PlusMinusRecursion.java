package src.practrice.week2;

import java.util.ArrayList;
import java.util.List;

public class PlusMinusRecursion {


    public static List<Integer> resultArr = new ArrayList<>();

    public static void main(String[] args) {
        int targetNum = 3;
        int targetCnt = 0;
        int [] arr = {1,1,1,1,1};

        plusMinusRecursion(arr, 0, 0);

        System.out.println(resultArr);
        for(int result : resultArr) {
            if(result == targetNum) {
                targetCnt++;
            }
        }
        System.out.println("targetCnt :: " + targetCnt);
    }

    public static void plusMinusRecursion(int [] arr, int index, int currentSum) {
        if(arr.length == index) {
            resultArr.add(currentSum);
            return;
        }

        plusMinusRecursion(arr, index + 1, currentSum + arr[index]);
        plusMinusRecursion(arr, index + 1, currentSum - arr[index]);
    }
}
