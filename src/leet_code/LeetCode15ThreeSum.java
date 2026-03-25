package src.leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15ThreeSum {
    /**
     * 하나 고정   (for문 작성을 할 수 밖에 없음)
     * 나머지 두개는 two pointer로 결정
     * 고정된 값 이후에 동일한 값이 나올 경우 중복되므로 스킵처리해야함
     * */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                if(nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }else {
                    // index 이동시에 중복값이 발생할 수 있으니 이 점도 참고해야함
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }
            }

        }

        return result;
    }


}
