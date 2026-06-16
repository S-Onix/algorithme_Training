package programmers;

public class CanConvertBinaryTree {
    /**
     * 주어진 숫자가 이진트리가 가능한가?
     * 조건
     *  시작 인덱스를 1로
     * [1,0,1,0,0,1,0,0,0,0,0,1,0]
     * 1의 자식 2,3
     * 2의 자식 4,5
     * 3의 자식 6,7
     * 3의 자식 7,8
     *
     * childIndex = parentIndex * 2 | parentIndex * 2 + 1
     * 포화 이진트리가 되야함.
     *
     * 노드 갯수는 2^n -1 이여야함.
     *
     * */

    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            // 여기에 코드를 작성하세요
            String binaryString = Long.toBinaryString(numbers[i]);
            int size = 1;
            while(size < binaryString.length()) size = size*2 + 1;
            while(binaryString.length() < size) binaryString = "0" + binaryString;

            answer[i] = check(binaryString, 0, binaryString.length() - 1) ? 1 : 0;
        }
        return answer;
    }

    public static boolean check(String binaryString, int start, int end) {
        if(start == end) return true;

        int mid = ( start + end ) / 2;
        if(binaryString.charAt(mid) == '0' ) {
            return !binaryString.substring(start, end+1).contains("1");
        }

        return check(binaryString, start, mid-1) && check(binaryString, mid+1, end);
    }
}
