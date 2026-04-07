package src.leet_code;

public class LeetCode70ClimbingStairs {

    public int climbStairs(int n) {
        int[] memory = new int[n + 1];

        if( n < 3) return n;

        memory[1] = 1;
        memory[2] = 2;

        for (int i = 3; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }

        return memory[n];

    }
}
