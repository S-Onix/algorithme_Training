package algorithm_fc.greedy;

import java.util.ArrayList;

public class MinCoin {

    public void coinFunc(Integer price, ArrayList<Integer> coinList) {
        Integer totalCoinCount = 0;
        Integer coinNum = 0;

        ArrayList<Integer> details = new ArrayList<>();

        for(int i = 0; i < coinList.size(); i++) {
            coinNum = price / coinList.get(i);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(i);
            details.add(coinNum);
            System.out.println(coinList.get(i)+ "원 : " + coinNum + "개");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> coinList = new ArrayList<>();
        coinList.add(500);
        coinList.add(100);
        coinList.add(50);
        coinList.add(10);
        coinList.add(1);

        MinCoin test = new MinCoin();
        test.coinFunc(4730, coinList);
    }

}
