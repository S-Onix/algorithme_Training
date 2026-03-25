package src.leet_code;

public class LeetCode167TwoSum2 {
    public int[] twoSum(int[] nums, int target) {

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while(leftIndex < rightIndex){
            if(nums[leftIndex] + nums[rightIndex] < target) {
                leftIndex++;
            }else if(nums[leftIndex] + nums[rightIndex] > target) {
                rightIndex--;
            }else {
                return new int [] {leftIndex+1, rightIndex+1};
            }
        }

        return new int [] {leftIndex+1, rightIndex+1};
    }
}
