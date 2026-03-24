package src.practrice.week1;

public class SwapNumber {
    public static void main(String[] args) {
        String test = "001010";
        System.out.println(solve(test));
    }

    public static int solve(String inputValue) {
        /**
         * 1. 모든 문자가 같을때(0 또는 1로 구성) >> 0 반환
         * 2. 문자가 다를때
         *     - 0과 1에 따른 뒤집기 개수 찾기
         *     - 두 개수 중 작은 값 반환
         * */

        int oneSwap = 0;
        int zeroSwap = 0;
        char firstChar = inputValue.charAt(0);

        if(!inputValue.contains("0")) {
            return 0;
        }

        if(!inputValue.contains("1")) {
            return 0;
        }

        for(int i = 1; i < inputValue.length(); i++) {
            if (i == 1 && firstChar == inputValue.charAt(i)) {
                continue;
            } else if (i == 1 && firstChar != inputValue.charAt(i)) {
                if (firstChar == '0') {
                    oneSwap++;
                } else {
                    zeroSwap++;
                }
            }

            if (inputValue.charAt(i) != inputValue.charAt(i - 1)) {
                if (inputValue.charAt(i) == '0') {
                    oneSwap++;
                } else {
                    zeroSwap++;
                }
            }
        }

        if(oneSwap >= zeroSwap) return zeroSwap;
        else return oneSwap;
    }
}
