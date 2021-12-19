package algorithm_fc.sort;

import java.util.ArrayList;


public class MergeSortRemind {
    /**
     * 분할하고 다시 조합한다.
     * 여기서 분할 조건 > 길이가 1이 될때까지
     *
     * 조합할때는?
     *
     * */

    public ArrayList<Integer> mergeSolution(ArrayList<Integer> left, ArrayList<Integer> right){
        ArrayList<Integer> resultArray = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        /**
         * 이 while문을 돌고나면 한쪽은 무조건 정렬이 끝나게 되어있다.
         * */
        while(left.size() > leftIndex && right.size() > rightIndex) {
            if(left.get(leftIndex) > right.get(rightIndex)) {
                resultArray.add(right.get(rightIndex));
                rightIndex++;
            }else {
                resultArray.add((left.get(leftIndex)));
                leftIndex++;
            }
        }

        /**
         * 왼쪽 혹은 오른쪽 리스트에 값이 남아있을수 있음
         * */

        if(leftIndex < left.size()){
            resultArray.addAll(left.subList(leftIndex,left.size()));
        }

        if(rightIndex < right.size()){
            resultArray.addAll(right.subList(rightIndex,right.size()));
        }

        return resultArray;
    }


    public ArrayList<Integer> splitArray(ArrayList<Integer> array){
        if(array.size() <= 1) {
            return array;
        }

        int medium = array.size() / 2;

        ArrayList<Integer> leftArray = splitArray(new ArrayList<>(array.subList(0, medium)));
        ArrayList<Integer> rightArray = splitArray(new ArrayList<>(array.subList(medium, array.size())));

        return mergeSolution(leftArray, rightArray);
    }

    public static void main(String[] args) {
        MergeSortRemind test = new MergeSortRemind();
        ArrayList<Integer> testArray = new ArrayList<Integer>();
        testArray.add(1);
        testArray.add(12);
        testArray.add(4);
        testArray.add(5);
        testArray.add(11);
        testArray.add(23);
        testArray.add(67);
        testArray.add(19);
        testArray.add(5);
        testArray.add(7);
        testArray.add(9);

        test.splitArray(testArray);






    }

}
