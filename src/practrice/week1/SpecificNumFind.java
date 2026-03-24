package src.practrice.week1;

public class SpecificNumFind {
    public static void main(String[] args) {
        int [] test = {1,2,3,4,5,7,8,9,0,199,12};
        boolean result = solve(test, 4);
        System.out.println(result);
    }

    public static boolean solve(int [] inputArray, int findValue) {
        for(int i = 0; i < inputArray.length; i++) {
            if(findValue == inputArray[i]) {
                return true;
            }
        }

        return false;
    }
}
