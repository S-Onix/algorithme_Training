package src.leet_code;

import java.util.Arrays;

public class LeetCode153FindMinimumInRotatedSortedArray {

    // for문을 이용한 풀이
    public int findMin1(int[] nums) {

        //회전이 된 경우
        /**
         * sector를 두군데로 나누면?
         * 회전된 곳을 찾으려면?
         *   - 다음 값이 현재 값보다 작아야함
         *   - 현재 값의 위치가 회전된 위치
         * */
        int rotateIndex = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i + 1]) {
                rotateIndex = i;
            }
        }

        if(nums.length == 1){
            return nums[0];
        }

        // 회전이 안된 경우
        return Math.min(nums[0], nums[rotateIndex+1]);
    }

    // binarySearch를 이용한 풀이
    public int findMin2(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;

        while(leftIndex < rightIndex){
            int mid = leftIndex + (rightIndex - leftIndex)/2;
            // 최소값이 오른쪽에 존재함
            if(nums[mid] > nums[rightIndex]){
                leftIndex = mid+1;
            }else { // 최소값이 왼쪽에 존재함
                rightIndex = mid;
            }
        }

        return nums[leftIndex];
    }
}
