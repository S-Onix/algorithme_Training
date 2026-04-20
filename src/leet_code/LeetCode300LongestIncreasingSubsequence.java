package src.leet_code;

import java.util.Arrays;

public class LeetCode300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        /**
         * 오름차순으로 이어질 수 있는 길이의 최대값을 구해라.
         * dp는 해당 위치에서의 최대값을 의미
         * */
        int max = 1;

        for(int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
