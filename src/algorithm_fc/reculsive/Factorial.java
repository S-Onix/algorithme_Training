package algorithm_fc.reculsive;

import java.util.ArrayList;

public class Factorial {

    public static int forFactorial(int n){
        int result = 1;

        for(int i = 1 ; i < n+1; i++) {
            System.out.printf("result * i = %d * %d = %d \n", result, i, result * i);
            result *= i;
        }

        return result;
    }

    public static int reculFactorial(int n) {
        if (n < 2) {
            return 1;
        }
        return n * reculFactorial(n-1);
    }

    public static int reculSum(ArrayList<Integer> dataList) {
        if(dataList.size() <= 0) {
            return 1;
        }

        return dataList.get(0) * reculSum(new ArrayList<>(dataList.subList(1, dataList.size())));
    }


    public static void main(String[] args) {
        System.out.println(forFactorial(5));
        System.out.println(reculFactorial(5));

        ArrayList<Integer> testList = new ArrayList<>();
        for(int i = 1; i < 11; i++) {
            testList.add(i);
        }
        System.out.println(reculSum(testList));
    }

}
