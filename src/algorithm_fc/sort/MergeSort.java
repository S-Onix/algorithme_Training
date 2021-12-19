package algorithm_fc.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static void divdeArray(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 0) {
            return;
        }

        int medium = arrayList.size() / 2;

        ArrayList<Integer>  leftArray = new ArrayList<>();
        ArrayList<Integer>  rightArray = new ArrayList<>();

        leftArray = new ArrayList<>(arrayList.subList(0, medium));
        rightArray = new ArrayList<>(arrayList.subList(medium, arrayList.size()));

        System.out.println(leftArray);
        System.out.println(rightArray);
    }

    public static ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if(dataList.size() <= 1) {
            return dataList;
        }

        int medium = dataList.size()/2;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        left = mergeSplitFunc(new ArrayList<>(dataList.subList(0,medium)));
        right = mergeSplitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));

        return mergeFunc(left, right);
    }

    public static ArrayList<Integer> mergeFunc(ArrayList<Integer> left, ArrayList<Integer> right){
        ArrayList<Integer> resultArray = new ArrayList<>();

        int leftArrayIndex = 0;
        int rightArrayIndex = 0;

        while(left.size() > leftArrayIndex && right.size() > rightArrayIndex){
            if(left.get(leftArrayIndex) > right.get(rightArrayIndex)) {
                resultArray.add(right.get(rightArrayIndex));
                rightArrayIndex++;
            }else {
                resultArray.add(left.get(leftArrayIndex));
                leftArrayIndex++;
            }
        }

        if(leftArrayIndex < left.size()){
            resultArray.addAll(left.subList(leftArrayIndex, left.size()));
        }

        if(rightArrayIndex < right.size()){
            resultArray.addAll(right.subList(rightArrayIndex, right.size()));
        }


        return resultArray;
    }

    public static void main(String[] args) {


        System.out.println(mergeSplitFunc(new ArrayList<Integer>(Arrays.asList(4,1,2,3,22,4))));
    }

}
