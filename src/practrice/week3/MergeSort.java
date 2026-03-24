package src.practrice.week3;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr1 = {1,2,4,6};
        int [] arr2 = {1,4,5,7};

        mergeSort(arr1, arr2);
    }

    public static void mergeSort(int[] arr1, int[] arr2) {
        int index1 = 0;
        int index2 = 0;

        List<Integer> result = new ArrayList<>();

        while(index1 < arr1.length && index2 < arr2.length) {
            if(arr1[index1] < arr2[index2]) {
                result.add(arr1[index1]);
                index1++;
            }else {
                result.add(arr2[index2]);
                index2++;
            }
        }

        while(index1 < arr1.length) {
            result.add(arr1[index1]);
            index1++;
        }

        while(index2 < arr2.length) {
            result.add(arr2[index1]);
            index2++;
        }

        System.out.println(result);

    }
}
