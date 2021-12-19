package algorithm_fc.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortRemind {

    public ArrayList<Integer> quickSort(ArrayList<Integer> array){
        if(array.size() <= 1) {
            return array;
        }

        int pivot = array.get(0);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();


        for(int i = 1 ; i < array.size(); i++) {
            if(pivot > array.get(i)){
                left.add(array.get(i));
            }else{
                right.add(array.get(i));
            }
        }

        ArrayList<Integer> mergedArray = new ArrayList<>();
        mergedArray.addAll(this.quickSort(left));
        mergedArray.addAll(Arrays.asList(pivot));
        mergedArray.addAll(this.quickSort(right));

        return mergedArray;
    }

    public static void main(String[] args) {
        QuickSortRemind test = new QuickSortRemind();

        ArrayList<Integer> testArr = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            testArr.add((int)(Math.random()*100));
        }

        System.out.println(test.quickSort(testArr));

    }

}
