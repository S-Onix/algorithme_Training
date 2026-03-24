package src.practrice.week3;

import java.util.ArrayList;
import java.util.List;

public class StackTower {
    static List<Integer> resultList = new ArrayList<Integer>();
    static List<Integer> resultList2 = new ArrayList<Integer>();

    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        inputList.add(6);
        inputList.add(9);
        inputList.add(5);
        inputList.add(7);
        inputList.add(4);

        solve(inputList);
    }

    public static void solve(List<Integer> inputList) {
        resultList.add(0);
        resultList2.add(0);

        for(int i = inputList.size() - 1; i >= 0; i--) {
            int target = inputList.get(i);
            for(int j = i -1; j >= 0; j--) {
                if(target < inputList.get(j)) {
                    resultList.add(j);
                    break;
                }

                if(j == 0) {
                    resultList.add(0);
                }
            }
        }

        for(int i = resultList.size()-1; i > 0; i--) {
            if(resultList.get(i) != 0) {
                resultList2.add(resultList.get(i)+1);
            }else{
                resultList2.add(0);
            }

        }

        System.out.println(resultList2);
    }
}
