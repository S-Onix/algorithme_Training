package src.practrice.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetPriceNotFall {
    public static void main(String[] args) {
        int [] prices = {1, 5, 3, 6, 7, 6, 5};
        solve(prices);
    }

    public static void solve(int [] prices){
        LinkedList<Integer> priceQueue = new LinkedList<>();
        int cnt = 0;
        List<Integer> resultList = new ArrayList<>();

        for(int price : prices) {
            priceQueue.offer(price);
        }

        while(!priceQueue.isEmpty()){
            int price = priceQueue.poll();

            for(Integer currentValue : priceQueue){
                cnt++;
                if(currentValue < price){
                    break;
                }
            }

            resultList.add(cnt);
            cnt = 0;
        }

        System.out.println(resultList);
    }
}
