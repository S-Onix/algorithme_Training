package Sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class SortCollect {

    /**
     * 버블정렬 : 양옆의 값들을 비교하여 순서를 바꾸는 정렬 알고리즘
     * */
    public static ArrayList bubbleSort(ArrayList<Integer> list) {
        for (int j = 0; j < list.size() - 1 ; j ++) {
            for (int i = 0; i < list.size() - 1 - j; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i + 1);
                }
            }
        }
        return list;
    }

    /**
     * 선택정렬 : 순회하는 중 가능 큰값 혹은 가장 작은 값을 선택하여 정렬하고자 하는 위치의 값과 바꾸는 정렬 알고리즘
     * */
    public static ArrayList selectionSort(ArrayList<Integer> list) {
        int maxIndex = 0;
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i+1; j < list.size(); j ++) {
                if(list.get(j) > list.get(maxIndex)) {
                    maxIndex = j;
                }
            }
            Collections.swap(list, maxIndex, i);
        }
        return list;
    }

    public static ArrayList insertionSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i ++) {
            for(int j = i + 1; j > 0; j--) {
                if(list.get(j) < list.get(j-1)) {
                    Collections.swap(list, j, j-1);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(12);
        arrayList.add(5);
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(22);
        arrayList.add(32);

        System.out.println(bubbleSort(arrayList));

    }
}
