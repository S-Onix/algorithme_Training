package src.practrice.week3;

import java.util.Arrays;
import java.util.Collections;

public class SSGMaxDisCount {

    public static void main(String[] args) {
        Integer [] prices = {30000, 2000, 1500000};
        Integer [] discounts = {20, 40};

        solve(prices, discounts);
    }

    public static void solve(Integer [] prices, Integer [] discounts) {
        /**
         * 정렬부터한다.
         * */

        Arrays.sort(prices, Collections.reverseOrder());
        Arrays.sort(discounts, Collections.reverseOrder());
        int sum = 0;

        for(int i = 0 ; i < prices.length ; i++) {
            int price = prices[i];
            if(i < discounts.length) {
                price -= (int) price * ((double) discounts[i] / 100);
                sum += price;
            }else {
                sum += price;
            }
        }

        System.out.println(sum);


    }
}
