package src.practrice.week1;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberFind {
    public static void main(String[] args) {
        List<Integer> result = solve(100);
        System.out.println(result);
    }

    public static List<Integer> solve(int inputValue) {
        List<Integer> primeList = new ArrayList<Integer>();
        boolean isPrime = true;

        for(int i = 2; i < inputValue; i++) {
            System.out.println(primeList);
            /**
             * 소수 판별하기
             * 자기 자신과 1 외에는 아무것도 나눌 수 없는 숫자
             * */
            for(int j = 0; j < primeList.size(); j++) {
                if(j*j <= i && i % primeList.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                primeList.add(i);
            }
            isPrime = true;
        }

        return primeList;
    }
}
