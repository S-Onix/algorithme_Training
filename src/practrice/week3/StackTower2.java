package src.practrice.week3;

public class StackTower2 {

    public static void main(String[] args) {
        int[] top_heights = {6, 9, 5, 7, 4};

        printArray(solve(top_heights));  // [0, 0, 2, 2, 4] 가 반환되어야 한다!

        System.out.print("정답 = [0, 0, 2, 2, 4] / 현재 풀이 값 = ");
        printArray(solve(new int[]{6, 9, 5, 7, 4}));

        System.out.print("정답 = [0, 0, 2, 3, 3, 3, 6] / 현재 풀이 값 = ");
        printArray(solve(new int[]{3, 9, 9, 3, 5, 7, 2}));

        System.out.print("정답 = [0, 0, 2, 0, 0, 5, 6] / 현재 풀이 값 = ");
        printArray(solve(new int[]{1, 5, 3, 6, 7, 6, 5}));
    }

        public static int[] solve(int [] inputValue){
        int [] result = new int[inputValue.length];
        Stack2 stack = new Stack2();

        for(int i = 0 ; i < inputValue.length ; i++){
            stack.push(inputValue[i]);
        }

        while(!stack.isEmpty()){
            int targetValue = stack.pop().data;
            int currentIndex = stack.size;

            for(int i = currentIndex-1; i >= 0; i--) {
                if(targetValue <= inputValue[i]){
                    result[currentIndex] = i+1;
                    break;
                }
            }
        }
        return result;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
