package src.leet_code;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1TwoSum {
    public int[] twoSum1(int[] nums, int target) {
        int [] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int [] result = new int[2];
        Map<Integer, Integer> pairMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(pairMap.containsKey(nums[i])) {
                result[0] = pairMap.get(nums[i]);
                result[1] = i;
                break;
            }
            pairMap.put(target - nums[i], i);
        }

        return result;
    }
}
