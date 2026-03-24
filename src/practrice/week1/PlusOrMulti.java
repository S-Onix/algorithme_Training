package src.practrice.week1;

public class PlusOrMulti {
    public static void main(String[] args) {
        int [] test = {0, 3, 5, 6, 1, 2, 4};
        int result = solve(test);
        System.out.println(result);
    }

    public static int solve(int [] arrayInput){
        int result = 0;

        for(int i = 0 ; i < arrayInput.length ; i++){
            if(result <= 1 || arrayInput[i] <= 1 ) {
                result += arrayInput[i];
            }else {
                result *= arrayInput[i];
            }

        }
        return result;
    }

}
