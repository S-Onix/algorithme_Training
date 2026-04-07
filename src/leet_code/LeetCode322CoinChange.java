package src.leet_code;

import java.util.Arrays;

public class LeetCode322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);  // 불가능한 값으로 초기화
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int coin : coins) {
                if(i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
