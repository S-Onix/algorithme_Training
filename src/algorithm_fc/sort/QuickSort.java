package algorithm_fc.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    /**
     * 기준점보다 작으면 왼쪽
     * 기준점보다 크면 오른쪽에 배치시킨다
     * >> 따라서 기준점을 입력받아야한다. (보통은 첫번째 위치에 있는 값을 지정한다.)
     *
     * 반복적으로 기준점을 기준으로 정렬해준다 >> 최종적으로는 모든 데이터가 정렬되는 효과가 나타난다.
     * top down 기법으로 큰 것을 작게 쪼게 정렬한다.
     * */

    public ArrayList<Integer> quickSort(ArrayList<Integer> array) {
        if(array.size() <= 1) {
            return array;
        }

        int pivot = array.get(0);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int i =1; i < array.size(); i++) {
            if(pivot > array.get(i)){
                left.add(array.get(i));
            }else {
                right.add(array.get(i));
            }
        }

        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        mergedList.addAll(this.quickSort(left));
        mergedList.addAll(Arrays.asList(pivot));
        mergedList.addAll(this.quickSort(right));

        return mergedList;

    }


    public static void main(String[] args) {
        QuickSort test = new QuickSort();

        ArrayList<Integer> testArr = new ArrayList<>();

        for(int i = 0 ; i < 100; i++) {
                testArr.add((int)(Math.random()*100));
        }
        System.out.println(test.quickSort(testArr));
    }
}
