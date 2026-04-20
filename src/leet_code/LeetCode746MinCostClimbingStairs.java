package src.leet_code;

public class LeetCode746MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int [cost.length+1];
        dp[0] = 0;
        dp[0] = 0;

        for(int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-2], dp[i-2] + cost[i-1]);
        }

        return dp[cost.length+1];
    }

}
