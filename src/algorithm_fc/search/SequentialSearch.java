package algorithm_fc.search;

import java.util.ArrayList;

public class SequentialSearch {

    public int sequentialSearch(Integer searchValue, ArrayList<Integer> array) {
        for(int i = 0 ; i < array.size(); i++) {
            if(array.get(i)== searchValue) {
                return array.get(i);
            }
        }

        return -1;
    }
}
