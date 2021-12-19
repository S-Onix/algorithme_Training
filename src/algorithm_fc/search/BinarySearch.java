package algorithm_fc.search;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    public boolean binarySearch(Integer searchValue, ArrayList<Integer> arrayList) {
        if(arrayList.size() == 1 && arrayList.get(0) == searchValue) {
            return true;
        }

        if(arrayList.size() == 1 && arrayList.get(0) != searchValue) {
            return false;
        }

        if(arrayList.size() == 0 ){
            return false;
        }

        int medium = arrayList.size()/2;

        if(arrayList.get(medium) == searchValue) {
            return true;
        }else {
            if (arrayList.get(medium) > searchValue){
                return this.binarySearch(searchValue, new ArrayList<Integer>(arrayList.subList(0, medium)));
            }else {
                return this.binarySearch(searchValue, new ArrayList<Integer>(arrayList.subList(medium, arrayList.size())));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for(int index = 0; index < 100; index++){
            testData.add((int)(Math.random()*100));
        }

        Collections.sort(testData);
        System.out.println(testData);

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(2, testData));
        System.out.println(binarySearch.binarySearch(1, testData));
        System.out.println(binarySearch.binarySearch(4, testData));

    }

}
