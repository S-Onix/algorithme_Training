package programmers;

public class TargetNumber {
    static int cnt = 0;

    static void solve(int K, int [] nums, int target, int value){
        if(K == nums.length){
            if(value == target) cnt++;
        }else{
            for(int cand = 0; cand < 2; cand++){
                if(cand == 0) {
                    solve(K+1, nums, target, value + nums[K]);
                }else {
                    solve(K+1, nums, target, value - nums[K]);
                }
            }
        }

    }

    public int solution(int[] numbers, int target) {
        solve(0, numbers, target,0);
        return cnt;
    }
}
