package algorithm_problem.twosum;

public class TwoSum {
    public int [] solve(int [] nums, int target){
        int array [] = new int [2];
        for(int i = 0 ; i < nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    array[0] = i;
                    array[1] = j;
                    System.out.println(array[0] + " " + array[1]);
                    return array;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum tw = new TwoSum();
        int input[] = {3,2,4};
        tw.solve(input, 6);
    }
}
