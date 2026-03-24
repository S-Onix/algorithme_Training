package src.practrice.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortRecursion {

    public static void main(String[] args) {
        int [] arr = {4,2,1,2,5,2,6,8,2,6,8,9};
        int [] result = mergeSort(arr);

        for(int i = 0 ; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int [] mergeSort(int [] arr) {
        if(arr.length <= 1){
            return arr;
        }
        int mid = arr.length/2;

        int [] left_arr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int [] right_arr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left_arr, right_arr);
    }

    public static int [] merge(int[] arr1, int[] arr2) {
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
            result.add(arr2[index2]);
            index2++;
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }
}
